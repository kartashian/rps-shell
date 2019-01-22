package com.wowapp.rps.component.strategy;

import com.wowapp.rps.domain.GameMove;
import com.wowapp.rps.domain.entity.Statistic;

/**
 * Strategy when user wins last game
 */
public class UserWinReverseMoveStrategy implements MoveStrategy {

    private Statistic lastGame;

    public UserWinReverseMoveStrategy(final Statistic lastGame) {
        this.lastGame = lastGame;
    }

    @Override
    public GameMove move() {
        GameMove botMove = lastGame.getBotMove();
        switch (botMove) {
            case ROCK:
                return GameMove.PAPER;
            case SCISSORS:
                return GameMove.ROCK;
            case PAPER:
                return GameMove.SCISSORS;
            default:
                return new RandomMoveStrategy().move();
        }
    }
}
