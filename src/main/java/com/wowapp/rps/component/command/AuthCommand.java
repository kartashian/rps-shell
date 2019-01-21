package com.wowapp.rps.component.command;

import com.wowapp.rps.component.Context;
import com.wowapp.rps.domain.dto.UserDto;
import com.wowapp.rps.domain.entity.User;
import com.wowapp.rps.service.UserService;

import java.util.Optional;

import static com.wowapp.rps.component.util.CommandLineUtil.print;

public class AuthCommand implements Command {

    private String userName;
    private UserService userService;

    public AuthCommand(String userName, UserService userService) {
        this.userName = userName;
        this.userService = userService;
    }

    @Override
    public boolean execute() {
        Optional<User> user;
        if (userService.exists(userName)) {
            user = userService.get(userName);
        } else {
            UserDto userDto = new UserDto();
            userDto.setName(userName);
            user = userService.create(userDto);
        }
        if (!user.isPresent()) {
            return false;
        }
        Context.THIS.setCurrentUser(user.get());
        print("Welcome, " + userName + "!");
        return true;
    }
}
