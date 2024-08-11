package com.swlo.postit.entities.dto;

public record NewUserDto(
        String name,
        String email,
        String password
) {
}
