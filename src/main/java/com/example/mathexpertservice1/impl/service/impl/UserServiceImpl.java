package com.example.mathexpertservice1.impl.service.impl;

import com.example.mathexpertservice1.api.dto.UserRsDto;
import com.example.mathexpertservice1.db.model.User;
import com.example.mathexpertservice1.db.repository.UserRepository;
import com.example.mathexpertservice1.impl.mapper.UserMapper;
import com.example.mathexpertservice1.impl.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserRsDto getUserInfo(String username) {
        var byUsername = userRepository.findByUsername(username);
        if (byUsername.isEmpty()){
            return userMapper.toUserRsDto(userRepository.save(User.builder().username(username).build()));
        }else {
            return userMapper.toUserRsDto(byUsername.get());
        }
    }
}
