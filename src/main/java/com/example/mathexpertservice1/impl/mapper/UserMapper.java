package com.example.mathexpertservice1.impl.mapper;

import com.example.mathexpertservice1.api.dto.UserRsDto;
import com.example.mathexpertservice1.db.model.User;

public interface UserMapper {
    UserRsDto toUserRsDto(User user);
}
