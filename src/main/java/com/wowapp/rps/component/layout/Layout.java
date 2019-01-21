package com.wowapp.rps.component.layout;

/**
 * Represents the same level commands scope.
 * Splits commands to user functional views
 */
public interface Layout {

    /**
     * @return layout name
     */
    String name();

    /**
     * Layout init method
     */
    void init();

    /**
     * Execute user input
     */
    void execute(String input);
}
