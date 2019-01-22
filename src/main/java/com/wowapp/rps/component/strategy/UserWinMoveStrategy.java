package com.wowapp.rps.component.strategy;

import com.wowapp.rps.domain.GameMove;
import com.wowapp.rps.domain.entity.Statistic;

/**
 * Strategy when user wins last game
 */
public class UserWinMoveStrategy implements MoveStrategy {

    private Statistic lastGame;

    public UserWinMoveStrategy(final Statistic lastGame) {
        this.lastGame = lastGame;
    }

    @Override
    public GameMove move() {
        return lastGame.getUserMove();
    }
}
