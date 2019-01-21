package com.wowapp.rps.service.impl;

import com.wowapp.rps.domain.dto.UserDto;
import com.wowapp.rps.domain.entity.User;
import com.wowapp.rps.repository.UserRepository;
import com.wowapp.rps.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Optional<User> create(final UserDto user) {
        if (user == null || StringUtils.isEmpty(user.getName())) {
            return Optional.empty();
        }
        User newUser = new User();
        newUser.setName(user.getName());
        return Optional.ofNullable(userRepository.saveAndFlush(newUser));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean exists(final String userName) {
        return !StringUtils.isEmpty(userName) &&
                userRepository.findByName(userName).isPresent();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> get(String userName) {
        return userRepository.findByName(userName);
    }
}
