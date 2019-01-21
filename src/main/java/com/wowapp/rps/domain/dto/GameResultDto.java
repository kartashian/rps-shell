package com.wowapp.rps.domain.dto;

import com.wowapp.rps.domain.GameMove;
import com.wowapp.rps.domain.GameResult;
import com.wowapp.rps.domain.entity.User;

import java.time.LocalDateTime;

public class GameResultDto {

    private User user;
    private GameMove userMove;
    private GameMove botMove;
    private LocalDateTime date;
    private GameResult result;

    public GameResultDto(User user, GameMove userMove, GameMove botMove,
                         LocalDateTime date, GameResult result) {
        this.user = user;
        this.userMove = userMove;
        this.botMove = botMove;
        this.date = date;
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GameMove getUserMove() {
        return userMove;
    }

    public void setUserMove(GameMove userMove) {
        this.userMove = userMove;
    }

    public GameMove getBotMove() {
        return botMove;
    }

    public void setBotMove(GameMove botMove) {
        this.botMove = botMove;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public GameResult getResult() {
        return result;
    }

    public void setResult(GameResult result) {
        this.result = result;
    }
}
