//package com.example.springcourses.api;
//
//import com.example.springcourses.dto.UserDto;
//import com.example.springcourses.security.RunAs;
//import com.example.springcourses.services.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.access.prepost.PostAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///*@RequiredArgsConstructor
//@RequestMapping("/api/users")
//@RestController*/
//public class UserRestController {
//
//
//    /*@Qualifier("userJpaService")
//    private final UserService userService;
//
//    @PostAuthorize("hasAuthority('TEACHER') || @tenancyAuthManager.checkUsersAccount(authentication, returnObject.userId)")
//    @GetMapping("/{id}")
//    public UserDto getById(@PathVariable Long id) {
//        return userService.findById(id);
//    }
//
//    @GetMapping
//    public List<UserDto> getAll() {
//        return (List<UserDto>) userService.findAll();
//    }
//
//    @PostMapping
//    public void create(@RequestBody UserDto userDto) {
//        userService.create(userDto);
//    }
//
//    @PutMapping("/{id}")
//    public void update(@PathVariable("id") Long userId, @RequestBody UserDto userDto) {
//        userService.update(userId, userDto);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable("id") Long userId) {
//        userService.delete(userId);
//    }
//
//    @PutMapping("/blockUnused")
//    public void blockUnusedUsers() {
//        RunAs.runAsSystem(userService::blockUnusedUsers);
//    }*/
//}
