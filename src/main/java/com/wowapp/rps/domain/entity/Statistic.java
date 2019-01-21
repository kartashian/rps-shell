package com.wowapp.rps.domain.entity;

import com.wowapp.rps.domain.GameMove;
import com.wowapp.rps.domain.GameResult;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = Statistic.TABLE_NAME)
public class Statistic {

    static final String TABLE_NAME = "statistic";
    private static final String SEQUENCE_NAME = TABLE_NAME + "_sequence";

    @Id
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    private Long id;

    @ManyToOne
    private User user;

    @Column
    private GameMove userMove;

    @Column
    private GameMove botMove;

    @Column
    private GameResult result;

    @Column
    private LocalDateTime date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public GameResult getResult() {
        return result;
    }

    public void setResult(GameResult result) {
        this.result = result;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
