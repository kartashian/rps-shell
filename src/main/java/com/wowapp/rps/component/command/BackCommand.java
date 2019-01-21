package com.wowapp.rps.component.command;

import com.wowapp.rps.component.Context;

public class BackCommand implements Command {

    @Override
    public boolean execute() {
        Context.THIS.previousLayout();
        return true;
    }
}
