package com.example.mathexpertservice1.impl.mapper.impl;

import com.example.mathexpertservice1.api.dto.UserRsDto;
import com.example.mathexpertservice1.db.model.User;
import com.example.mathexpertservice1.impl.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserRsDto toUserRsDto(User user) {
        return UserRsDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}
