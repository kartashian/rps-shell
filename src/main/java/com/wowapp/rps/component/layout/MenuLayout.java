package com.wowapp.rps.component.layout;

import com.wowapp.rps.component.command.ChangeLayoutCommand;
import com.wowapp.rps.component.command.HelpCommand;
import com.wowapp.rps.domain.CommandName;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static com.wowapp.rps.component.util.CommandLineUtil.printCommands;

@Component
public class MenuLayout extends AbstractLayout {

    public MenuLayout(@Qualifier("gameLayout") Layout gameLayout,
                      @Qualifier("statisticLayout") Layout statisticLayout) {
        super();
        commands().put(CommandName.PLAY_GAME, () -> new ChangeLayoutCommand(gameLayout));
        commands().put(CommandName.STATISTICS, () -> new ChangeLayoutCommand(statisticLayout));
        commands().put(CommandName.HELP, () -> new HelpCommand(commands().keySet()));
    }

    @Override
    public String name() {
        return "menu";
    }

    @Override
    public void init() {
        List<CommandName> guidCommands = Arrays.asList(CommandName.PLAY_GAME,
                CommandName.STATISTICS, CommandName.HELP);
        printCommands("MENU \n", guidCommands);
    }
}
