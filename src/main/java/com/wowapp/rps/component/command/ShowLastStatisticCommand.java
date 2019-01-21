package com.wowapp.rps.component.command;

import com.wowapp.rps.component.Context;
import com.wowapp.rps.domain.entity.Statistic;
import com.wowapp.rps.service.StatisticService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static com.wowapp.rps.component.util.CommandLineUtil.printStatisticPage;

public class ShowLastStatisticCommand implements Command {

    private int size;
    private final StatisticService statisticService;

    public ShowLastStatisticCommand(int size, StatisticService statisticService) {
        this.size = size;
        this.statisticService = statisticService;
    }

    @Override
    public boolean execute() {
        PageRequest request = PageRequest.of(0, size, Sort.Direction.DESC, "id");
        Page<Statistic> statistic = statisticService.getUserStatistic(Context.THIS.currentUser(), request);
        printStatisticPage(statistic);
        return true;
    }
}
