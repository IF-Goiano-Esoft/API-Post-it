package com.swlo.postit.resources;

import com.swlo.postit.entities.dto.AuthDto;
import com.swlo.postit.entities.dto.NewUserDto;
import com.swlo.postit.entities.dto.UserDto;
import com.swlo.postit.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    private final UsersService usersService;

    @Autowired
    public UserResource(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/create")
    public void createUser(@RequestBody NewUserDto rawUser) {
        usersService.createUser(rawUser);
    }

    @PostMapping("/auth")
    public Long authenticateUser(@RequestBody AuthDto rawUser) {
        return usersService.authenticateUser(rawUser);
    }


}
