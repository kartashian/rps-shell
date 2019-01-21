package com.wowapp.rps.component.command;

import com.wowapp.rps.domain.GameMove;
import com.wowapp.rps.domain.dto.GameResultDto;
import com.wowapp.rps.service.PlayService;

import static com.wowapp.rps.component.util.CommandLineUtil.print;

public class PlayCommand implements Command {

    private GameMove move;
    private PlayService playService;

    public PlayCommand(GameMove move, PlayService playService) {
        this.move = move;
        this.playService = playService;
    }

    @Override
    public boolean execute() {
        GameResultDto result = playService.play(move);
        String message = "My move is " + result.getBotMove().name() + ".\n" +
                result.getUserMove().name() + " vs " + result.getBotMove().name() + "\n" +
                "Your result is " + result.getResult().name();
        print(message);
        return true;
    }
}
