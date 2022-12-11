package com.example.mathexpertservice1.api.controller;

import com.example.mathexpertservice1.api.dto.UserRsDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/users")
public interface UserControllerV1 {

    @GetMapping("/{username}")
    UserRsDto getUserInfo(@PathVariable("username") String username);

}
