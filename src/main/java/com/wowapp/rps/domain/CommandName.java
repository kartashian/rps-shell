package com.wowapp.rps.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CommandName {

    PLAY_GAME("g", "Play Game"),
    STATISTICS("st", "Show Statistic"),
    ALL_STATISTIC("all", "Show All"),
    LAST_STATISTIC("l", "Last 50 Records"),
    ROCK("r", "Rock"),
    PAPER("p", "Paper"),
    SCISSORS("s", "Scissors"),
    HELP("h", "Help"),
    BACK("b", "Go Back"),
    QUIT("q", "Quit"),
    EMPTY("", "");

    private String name;
    private String description;

    private static final Map<String, CommandName> COMMAND_NAME_MAP = Stream.of(CommandName.values())
            .collect(Collectors.toMap(CommandName::getName, c -> c));

    CommandName(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static CommandName findCommand(String name) {
        return COMMAND_NAME_MAP.getOrDefault(name, EMPTY);
    }
}
