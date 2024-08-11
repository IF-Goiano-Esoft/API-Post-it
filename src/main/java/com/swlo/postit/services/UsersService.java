package com.swlo.postit.services;

import com.swlo.postit.entities.Users;
import com.swlo.postit.entities.dto.AuthDto;
import com.swlo.postit.entities.dto.UserDto;
import com.swlo.postit.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository repository;

    @Autowired
    public UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public void createUser(UserDto rawUser) {
        Users user = new Users();
        user.setName(rawUser.name());
        user.setEmail(rawUser.email());
        user.setPassword(rawUser.password());

        repository.save(user);
    }

    public Users getUser(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Long authenticateUser(AuthDto rawAuth) {
        Users user = repository.findByEmail(rawAuth.email());
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        if (!user.getPassword().equals(rawAuth.password())) {
            throw new IllegalArgumentException("Invalid password");
        }
        return user.getId();
    }
}
