package com.wowapp.rps.service;

import com.wowapp.rps.domain.dto.UserDto;
import com.wowapp.rps.domain.entity.User;

import java.util.Optional;

public interface UserService {

    /**
     * Create a new user
     *
     * @param dto user dto
     * @return created user
     */
    Optional<User> create(UserDto dto);

    /**
     * Check if user with given name exists
     */
    boolean exists(String userName);

    /**
     * Fetch user by name
     *
     * @param userName username
     * @return user
     */
    Optional<User> get(String userName);
}
