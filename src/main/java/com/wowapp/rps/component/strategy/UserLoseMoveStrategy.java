package com.wowapp.rps.component.strategy;

import com.wowapp.rps.domain.GameMove;
import com.wowapp.rps.domain.entity.Statistic;

/**
 * Strategy when the user loses last game
 */
public class UserLoseMoveStrategy implements MoveStrategy {

    private Statistic lastGame;

    public UserLoseMoveStrategy(final Statistic lastGame) {
        this.lastGame = lastGame;
    }

    @Override
    public GameMove move() {
        GameMove botMove = lastGame.getBotMove();
        switch (botMove) {
            case ROCK:
                return GameMove.SCISSORS;
            case SCISSORS:
                return GameMove.PAPER;
            case PAPER:
                return GameMove.ROCK;
            default:
                return new RandomMoveStrategy().move();
        }
    }
}
