package com.wowapp.rps.component.command;

/**
 * Command implementation interface
 */
public interface Command {

    /**
     * Execute command
     *
     * @return true if execution was successful
     */
    boolean execute();
}
