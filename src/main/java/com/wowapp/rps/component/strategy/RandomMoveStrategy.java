package com.wowapp.rps.component.strategy;

import com.wowapp.rps.domain.GameMove;

import java.security.SecureRandom;

/**
 * Choose move randomly
 */
public class RandomMoveStrategy implements MoveStrategy {

    private final SecureRandom random;

    public RandomMoveStrategy() {
        random = new SecureRandom();
    }

    @Override
    public GameMove move() {
        return randomMove();
    }

    private GameMove randomMove(){
        int x = random.nextInt(GameMove.class.getEnumConstants().length);
        return GameMove.class.getEnumConstants()[x];
    }
}
