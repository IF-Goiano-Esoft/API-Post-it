package com.swlo.postit.entities.dto;

import java.io.Serializable;

public record UserDto(
        Long id,
        String name,
        String email,
        String password
) implements Serializable {
}
