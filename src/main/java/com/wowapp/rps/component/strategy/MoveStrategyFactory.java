package com.wowapp.rps.component.strategy;

import com.wowapp.rps.domain.GameResult;
import com.wowapp.rps.domain.entity.Statistic;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public enum MoveStrategyFactory {

    INSTANCE;

    private static final SecureRandom RANDOM = new SecureRandom();

    private int randomizeCount;

    public MoveStrategy getStrategy(List<Statistic> statistic) {
        if (statistic == null || statistic.isEmpty()) {
            return new RandomMoveStrategy();
        }

        LinkedList<Statistic> sorted = statistic.stream()
                .sorted(Comparator.comparing(Statistic::getDate))
                .collect(Collectors.toCollection(LinkedList::new));
        return select(sorted);
    }

    private MoveStrategy select(LinkedList<Statistic> sortedStatistic) {
        Statistic lastGame = sortedStatistic.getLast();
        LocalDateTime now = LocalDateTime.now();
        boolean gameIsOld = lastGame.getDate().until(now, ChronoUnit.MINUTES) > 2;
        if (gameIsOld) {
            return new RandomMoveStrategy();
        }

        GameResult userResult = lastGame.getResult();
        if (GameResult.WIN == userResult) {
            return peekRandomized(new UserWinMoveStrategy(lastGame),
                    new UserWinReverseMoveStrategy(lastGame));
        }
        if (GameResult.LOSE == userResult) {
            return peekRandomized(new UserLoseMoveStrategy(lastGame),
                    new UserLoseSecondMoveStrategy(lastGame));
        }
        if (GameResult.DRAW == userResult) {
            return peekRandomized(new UserDrawMoveStrategy(lastGame));
        }

        return new RandomMoveStrategy();
    }

    /**
     * Used for purpose user can not forecast the bot moves, if he recognize a strategy
     */
    private MoveStrategy peekRandomized(MoveStrategy... strategies) {
        if (isPeekRandomly() || strategies == null || strategies.length == 0) {
            return new RandomMoveStrategy();
        }

        if (strategies.length > 1) {
            int randomIndex = RANDOM.nextInt(strategies.length);
            return strategies[randomIndex];
        }
        return strategies[0];
    }

    private boolean isPeekRandomly() {
        if (randomizeCount <= 0) {
            randomizeCount = RANDOM.nextInt(4);
            return true;
        }
        randomizeCount--;
        return false;
    }
}
