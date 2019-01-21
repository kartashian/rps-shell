package com.wowapp.rps.service.impl;

import com.wowapp.rps.domain.dto.UserDto;
import com.wowapp.rps.domain.entity.User;
import com.wowapp.rps.repository.UserRepository;
import com.wowapp.rps.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService userService;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void createTest() {
        when(userRepository.saveAndFlush(any())).then(returnsFirstArg());
        UserDto dto = new UserDto();
        dto.setName("Sam");
        User user = userService.create(dto).get();
        assertEquals(dto.getName(), user.getName());
    }

    @Test
    public void existsTest() {
        when(userRepository.findByName(any())).thenReturn(Optional.of(new User()));
        boolean exists = userService.exists("Sam");
        assertTrue(exists);
    }

    @Test
    public void notExistsTest() {
        when(userRepository.findByName(any())).thenReturn(Optional.empty());
        boolean exists = userService.exists("Sam");
        assertFalse(exists);
    }
}