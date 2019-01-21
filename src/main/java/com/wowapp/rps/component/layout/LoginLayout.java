package com.wowapp.rps.component.layout;

import com.wowapp.rps.component.command.AuthCommand;
import com.wowapp.rps.component.command.ChangeLayoutCommand;
import com.wowapp.rps.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static com.wowapp.rps.component.util.CommandLineUtil.print;

@Component
public class LoginLayout implements Layout {

    private final UserService userService;
    private final Layout menuLayout;

    public LoginLayout(UserService userService,
                       @Qualifier("menuLayout") Layout menuLayout) {
        this.userService = userService;
        this.menuLayout = menuLayout;
    }

    @Override
    public String name() {
        return "";
    }

    @Override
    public void init() {
        print("Hi, this is Rock, Paper, Scissors Shell! My name is Robert!\n" +
                "Please enter your name:");
    }

    @Override
    public void execute(final String input) {
        boolean isAuth = new AuthCommand(input, userService).execute();
        if (isAuth) {
            new ChangeLayoutCommand(menuLayout).execute();
        } else {
            print("Incorrect user name, please try again:");
        }
    }
}
