package com.example.springcourses.controller;

import com.example.springcourses.dto.StudentDto;
import com.example.springcourses.dto.TeacherDto;
import com.example.springcourses.dto.UserDetailsDto;
import com.example.springcourses.dto.UserDto;
import com.example.springcourses.entity.UserRole;
import com.example.springcourses.entity.UserStatus;
import com.example.springcourses.security.CustomPasswordEncoderFactories;
import com.example.springcourses.services.UserService;
import com.example.springcourses.specification.filter.UserFilter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/users")
@Controller
public class UserController {

    private final UserService userService;

    @InitBinder
    public void setNotAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("userId");
    }


    @GetMapping("/index")
    public String getUsers(Model model) {
        Collection<UserDto> users = userService.findAll();
        model.addAttribute("users", users);
        return "users/index";
    }


    @GetMapping("/{id}")
    public String showUser(@PathVariable(name = "id") Long userId, Model model) {
        UserDetailsDto userDetailsDto = userService.findUserDetailsById(userId);
        model.addAttribute("userDto", userDetailsDto);
        if (userDetailsDto.getUserRole().equals(UserRole.STUDENT)
                && !userService.isStudentExists(userDetailsDto)) {
            model.addAttribute("student", StudentDto.builder().build());
            return "redirect:/users/" + userDetailsDto.getUserId() + "/students/new/";
        } else {
            if (userDetailsDto.getUserRole().equals(UserRole.TEACHER)
                    && !userService.isTeacherExists(userDetailsDto)) {
                model.addAttribute("teacher", TeacherDto.builder().build());
                return "redirect:/users/" + userDetailsDto.getUserId() + "/teachers/new/";
            }
        }
        return "users/userDetails";
    }


    @GetMapping("/find")
    public String findUsers(Model model) {
        model.addAttribute("userFilter", UserFilter.builder().build());
        return "users/findUsers";
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping
    public String processFindUsers(UserFilter filter, Model model, BindingResult bindingResult) {
        List<UserDto> result = userService.search(filter).getContent();
        if (CollectionUtils.isEmpty(result)) {
            //model.addAttribute("user", UserFilter.builder().build());
            bindingResult.rejectValue("term", "not found", "not found");
            return "users/findUsers";
        } else if (result.size() == 1) {
            UserDto userDto = result.get(0);
            return "redirect:/users/" + userDto.getUserId();
        } else {
            model.addAttribute("selections", result);
            return "users/usersList";
        }
    }


    @GetMapping("/new")
    public String initialCreationForm(Model model) {
        model.addAttribute("userDto", UserDto.builder().build());
        return "users/createOrUpdateUser";
    }

    @PreAuthorize("hasAuthority('TEACHER') || @tenancyAuthManager.checkUsersAccount(authentication, #userDto.userId)")
    @GetMapping("/{userId}/edit")
    public String initUpdateForm(Model model, @PathVariable Long userId) {
        model.addAttribute("userDto", userService.findById(userId));
        return "users/createOrUpdateUser";
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/new")
    public String processCreation(UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/createOrUpdateUser";
        } else {
            userService.save(userDto);
            return "redirect:/users/find";
        }
    }

    @PreAuthorize("hasAuthority('TEACHER') || #userDto.userId")
    @PostMapping("/{userId}/edit")
    public String processUpdate(@Valid UserDto userDto, BindingResult bindingResult, @PathVariable Long userId) {
        if (bindingResult.hasErrors()) {
            return "users/createOrUpdateUser";
        } else {
            userDto.setUserId(userId);
            userService.save(userDto);
            return "redirect:/users/" + userId;
        }
    }

    @GetMapping("/signIn")
    public String initSingIn(Model model) {
        model.addAttribute("userDto", UserDto.builder().userRole(UserRole.STUDENT).build());
        return "users/signIn";
    }

    @PostMapping("/signIn")
    public String processSingIn(@Valid UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/signIn";
        }
        if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "err", "Don't matches");
            return "users/signIn";
        }
        if (userService.existsByLogin(userDto.getLogin())) {
            bindingResult.rejectValue("login", "err", "Login is exists");
            return "users/signIn";
        }
        userDto.setPassword(CustomPasswordEncoderFactories.createDelegatingPasswordEncoder().encode(userDto.getPassword()));
        System.out.println(userDto.getFirstName());
        userService.addStudent(userDto);
        return "/index";
    }

    @ModelAttribute("roles")
    public Collection<UserRole> populateUserRoles() {
        return Arrays.asList(UserRole.values());
    }

    @ModelAttribute("statuses")
    public Collection<UserStatus> populateUserStatuses() {
        return Arrays.asList(UserStatus.values());
    }
}



