package com.wowapp.rps.component.strategy;

import com.wowapp.rps.domain.GameMove;

/**
 * RPS move strategy
 */
public interface MoveStrategy {

    /**
     * Select a move by implemented strategy
     * @return move
     */
    GameMove move();
}
