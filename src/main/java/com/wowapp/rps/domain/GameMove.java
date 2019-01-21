package com.wowapp.rps.domain;

public enum GameMove {
    ROCK {
        @Override
        public GameResult versus(GameMove move) {
            GameResult result = GameResult.LOSE;
            if (ROCK == move) {
                result = GameResult.DRAW;
            }
            if (SCISSORS == move) {
                result = GameResult.WIN;
            }
            return result;
        }
    },
    PAPER {
        @Override
        public GameResult versus(GameMove move) {
            GameResult result = GameResult.LOSE;
            if (PAPER == move) {
                result = GameResult.DRAW;
            }
            if (ROCK == move) {
                result = GameResult.WIN;
            }
            return result;
        }
    },
    SCISSORS {
        @Override
        public GameResult versus(GameMove move) {
            GameResult result = GameResult.LOSE;
            if (SCISSORS == move) {
                result = GameResult.DRAW;
            }
            if (PAPER == move) {
                result = GameResult.WIN;
            }
            return result;
        }
    };

    public abstract GameResult versus(GameMove move);
}
