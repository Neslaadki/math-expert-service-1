package com.example.mathexpertservice1.impl.controller;

import com.example.mathexpertservice1.api.controller.UserControllerV1;
import com.example.mathexpertservice1.api.dto.UserRsDto;
import com.example.mathexpertservice1.impl.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserControllerV1Impl implements UserControllerV1 {
    private final UserService userService;

    @Override
    public UserRsDto getUserInfo(String username) {
        return userService.getUserInfo(username);
    }
}
