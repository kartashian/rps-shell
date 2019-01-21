package com.wowapp.rps.component.layout;

import com.wowapp.rps.component.command.HelpCommand;
import com.wowapp.rps.component.command.ShowAllStatisticCommand;
import com.wowapp.rps.component.command.ShowLastStatisticCommand;
import com.wowapp.rps.domain.CommandName;
import com.wowapp.rps.service.StatisticService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static com.wowapp.rps.component.util.CommandLineUtil.printCommands;

@Component
public class StatisticLayout extends AbstractLayout {

    public StatisticLayout(StatisticService statisticService) {
        commands().put(CommandName.ALL_STATISTIC, () -> new ShowAllStatisticCommand(statisticService));
        commands().put(CommandName.LAST_STATISTIC, () -> new ShowLastStatisticCommand(50, statisticService));
        commands().put(CommandName.HELP, () -> new HelpCommand(commands().keySet()));
    }

    @Override
    public String name() {
        return "statistic";
    }

    @Override
    public void init() {
        List<CommandName> guidCommands = Arrays.asList(CommandName.ALL_STATISTIC,
                CommandName.LAST_STATISTIC, CommandName.HELP);
        printCommands("STATISTIC \n", guidCommands);
    }
}
