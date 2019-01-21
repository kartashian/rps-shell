package com.wowapp.rps.component.command;

import java.util.function.Supplier;

/**
 * Represents command listener interface
 *
 * Stores the command and execute it on action
 */
public interface CommandListener extends Supplier<Command> {

    /**
     * Execute stored command
     * @return result of command execution
     */
    default boolean action() {
        return get().execute();
    }
}
