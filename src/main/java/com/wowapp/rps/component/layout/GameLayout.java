package com.wowapp.rps.component.layout;

import com.wowapp.rps.component.command.HelpCommand;
import com.wowapp.rps.component.command.PlayCommand;
import com.wowapp.rps.domain.CommandName;
import com.wowapp.rps.domain.GameMove;
import com.wowapp.rps.service.PlayService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static com.wowapp.rps.component.util.CommandLineUtil.printCommands;

@Component
public class GameLayout extends AbstractLayout {

    public GameLayout(PlayService playService) {
        super();

        commands().put(CommandName.ROCK, () -> new PlayCommand(GameMove.ROCK, playService));
        commands().put(CommandName.PAPER, () -> new PlayCommand(GameMove.PAPER, playService));
        commands().put(CommandName.SCISSORS, () -> new PlayCommand(GameMove.SCISSORS, playService));
        commands().put(CommandName.HELP, () -> new HelpCommand(commands().keySet()));
    }

    @Override
    public String name() {
        return "game";
    }

    @Override
    public void init() {
        List<CommandName> guidCommands = Arrays.asList(CommandName.ROCK,
                CommandName.PAPER, CommandName.SCISSORS, CommandName.HELP);
        printCommands("GAME \n\nChoose one of the moves:", guidCommands);
    }
}
