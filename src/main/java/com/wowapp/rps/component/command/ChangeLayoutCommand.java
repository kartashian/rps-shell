package com.wowapp.rps.component.command;

import com.wowapp.rps.component.Context;
import com.wowapp.rps.component.layout.Layout;

public class ChangeLayoutCommand implements Command {

    private Layout nextLayout;

    public ChangeLayoutCommand(Layout nextLayout) {
        this.nextLayout = nextLayout;
    }

    @Override
    public boolean execute() {
        Context.THIS.nextLayout(nextLayout);
        return true;
    }
}
