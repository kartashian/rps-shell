package com.wowapp.rps.component.strategy;

import com.wowapp.rps.domain.GameMove;
import com.wowapp.rps.domain.entity.Statistic;

/**
 * Strategy when last game result was a draw
 */
public class UserDrawMoveStrategy implements MoveStrategy {

    private Statistic lastGame;

    public UserDrawMoveStrategy(final Statistic lastGame) {
        this.lastGame = lastGame;
    }

    @Override
    public GameMove move() {
        return new UserWinMoveStrategy(lastGame).move();
    }
}
