package com.example.springcourses.api;

import com.example.springcourses.dto.SystemLogDto;
import com.example.springcourses.dto.SystemOptionDto;
import com.example.springcourses.services.SystemLogService;
import com.example.springcourses.services.SystemOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(name = "/api/system")
@RestController
public class SystemController {

    private final SystemLogService systemLogService;
    private final SystemOptionService systemOptionService;

    @GetMapping("/logs")
    public List<SystemLogDto> getLogs() {
        return systemLogService.getAll();
    }

    @GetMapping("/options/{id}")
    public SystemOptionDto getById(@PathVariable("id") String optionKey) {
        return systemOptionService.getById(optionKey);
    }

    @GetMapping("/options")
    public List<SystemOptionDto> getSystem() {
        return systemOptionService.getAll();
    }

    @PutMapping("/options")
    public void saveOption(@RequestBody SystemOptionDto option) {
        systemOptionService.save(option);
    }

}
