package com.wowapp.rps.component.command;

import com.wowapp.rps.component.Context;
import com.wowapp.rps.domain.entity.Statistic;
import com.wowapp.rps.service.StatisticService;

import java.util.List;

import static com.wowapp.rps.component.util.CommandLineUtil.printStatistic;

public class ShowAllStatisticCommand implements Command {

    private final StatisticService statisticService;

    public ShowAllStatisticCommand(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @Override
    public boolean execute() {
        List<Statistic> statistic = statisticService.getUserStatistic(Context.THIS.currentUser());
        printStatistic(statistic);
        return true;
    }
}
