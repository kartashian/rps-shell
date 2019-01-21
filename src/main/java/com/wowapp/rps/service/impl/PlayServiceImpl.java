package com.wowapp.rps.service.impl;

import com.wowapp.rps.component.Context;
import com.wowapp.rps.domain.GameMove;
import com.wowapp.rps.domain.GameResult;
import com.wowapp.rps.domain.dto.GameResultDto;
import com.wowapp.rps.service.PlayService;
import com.wowapp.rps.service.StatisticService;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
public class PlayServiceImpl implements PlayService {

    private final SecureRandom random;
    private final StatisticService statisticService;

    public PlayServiceImpl(StatisticService statisticService) {
        this.statisticService = statisticService;
        this.random = new SecureRandom();
    }

    @Override
    public GameResultDto play(GameMove userMove) {
        if (userMove == null) {
            throw new IllegalArgumentException("User move can't be null");
        }

        GameMove botMove = generateBotMove();
        GameResult gameResult = userMove.versus(botMove);
        GameResultDto result = new GameResultDto(Context.THIS.currentUser(),
                userMove, botMove, LocalDateTime.now(), gameResult);
        statisticService.save(result);
        return result;
    }

    private GameMove generateBotMove() {
        return randomMove();
    }

    private GameMove randomMove(){
        int x = random.nextInt(GameMove.class.getEnumConstants().length);
        return GameMove.class.getEnumConstants()[x];
    }
}
