package com.wowapp.rps.component.strategy;

import com.wowapp.rps.domain.GameMove;
import com.wowapp.rps.domain.entity.Statistic;

/**
 * Strategy when the user loses last game
 */
public class UserLoseSecondMoveStrategy implements MoveStrategy {

    private Statistic lastGame;

    public UserLoseSecondMoveStrategy(final Statistic lastGame) {
        this.lastGame = lastGame;
    }

    @Override
    public GameMove move() {
        return new UserWinReverseMoveStrategy(lastGame).move();
    }
}
