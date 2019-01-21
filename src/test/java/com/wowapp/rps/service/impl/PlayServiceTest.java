package com.wowapp.rps.service.impl;

import com.wowapp.rps.domain.GameMove;
import com.wowapp.rps.domain.dto.GameResultDto;
import com.wowapp.rps.service.PlayService;
import com.wowapp.rps.service.StatisticService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PlayServiceTest {

    @Mock
    private StatisticService statisticService;
    private PlayService playService;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        this.playService = new PlayServiceImpl(statisticService);
    }

    @Test
    public void playTest() {
        when(statisticService.save(any())).thenReturn(any());

        GameResultDto resultDto = playService.play(GameMove.SCISSORS);
        assertNotNull(resultDto);
        assertNotNull(resultDto.getBotMove());
        assertNotNull(resultDto.getDate());
        assertNotNull(resultDto.getResult());
        assertEquals(resultDto.getUserMove(), GameMove.SCISSORS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void playTestFail() {
        playService.play(null);
    }

}