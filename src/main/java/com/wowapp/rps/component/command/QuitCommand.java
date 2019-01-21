package com.wowapp.rps.component.command;

import com.wowapp.rps.component.Context;

import static com.wowapp.rps.component.util.CommandLineUtil.print;

public class QuitCommand implements Command {

    @Override
    public boolean execute() {
        Context.THIS.stopRunning();
        print("Goodbye, " + Context.THIS.getUserName());
        return true;
    }
}
