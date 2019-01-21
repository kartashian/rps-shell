package com.wowapp.rps.component.command;

import com.wowapp.rps.domain.CommandName;

import java.util.Collection;

import static com.wowapp.rps.component.util.CommandLineUtil.printCommands;

public class HelpCommand implements Command {

    private Collection<CommandName> commands;

    public HelpCommand(Collection<CommandName> commands) {
        this.commands = commands;
    }

    @Override
    public boolean execute() {
        printCommands("Help:\n", commands);
        return true;
    }
}
