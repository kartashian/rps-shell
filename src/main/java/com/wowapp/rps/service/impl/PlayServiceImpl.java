package com.wowapp.rps.service.impl;

import com.wowapp.rps.component.Context;
import com.wowapp.rps.component.strategy.MoveStrategy;
import com.wowapp.rps.component.strategy.MoveStrategyFactory;
import com.wowapp.rps.domain.GameMove;
import com.wowapp.rps.domain.GameResult;
import com.wowapp.rps.domain.dto.GameResultDto;
import com.wowapp.rps.domain.entity.Statistic;
import com.wowapp.rps.service.PlayService;
import com.wowapp.rps.service.StatisticService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PlayServiceImpl implements PlayService {

    private final StatisticService statisticService;

    public PlayServiceImpl(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @Override
    public GameResultDto play(GameMove userMove) {
        if (userMove == null) {
            throw new IllegalArgumentException("User move can't be null");
        }

        MoveStrategy strategy = selectMoveStrategy();
        GameMove botMove = strategy.move();
        GameResult gameResult = userMove.versus(botMove);
        GameResultDto result = new GameResultDto(Context.THIS.currentUser(),
                userMove, botMove, LocalDateTime.now(), gameResult);
        statisticService.save(result);
        return result;
    }

    private MoveStrategy selectMoveStrategy() {
        PageRequest lastRecordRequest = PageRequest.of(0, 1, Sort.Direction.DESC, "id");
        Page<Statistic> statistic = statisticService.getUserStatistic(Context.THIS.currentUser(), lastRecordRequest);
        return MoveStrategyFactory.INSTANCE.getStrategy(statistic.getContent());
    }
}
