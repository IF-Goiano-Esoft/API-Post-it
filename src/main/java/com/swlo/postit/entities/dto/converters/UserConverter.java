package com.swlo.postit.entities.dto.converters;

import com.swlo.postit.entities.Users;
import com.swlo.postit.entities.dto.UserDto;

public class UserConverter {

    public static UserDto toDto(Users users) {
        return new UserDto(
                users.getId(),
                users.getName(),
                users.getEmail(),
                users.getPassword()
        );
    }
}
