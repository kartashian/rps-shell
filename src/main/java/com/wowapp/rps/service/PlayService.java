package com.wowapp.rps.service;

import com.wowapp.rps.domain.GameMove;
import com.wowapp.rps.domain.dto.GameResultDto;

public interface PlayService {

    /**
     * Generate random game between user and program
     * @param userMove user game move
     * @return result of the game
     */
    GameResultDto play(GameMove userMove);
}
