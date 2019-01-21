package com.wowapp.rps.service.impl;

import com.wowapp.rps.domain.GameMove;
import com.wowapp.rps.domain.GameResult;
import com.wowapp.rps.domain.dto.GameResultDto;
import com.wowapp.rps.domain.entity.Statistic;
import com.wowapp.rps.domain.entity.User;
import com.wowapp.rps.repository.StatisticRepository;
import com.wowapp.rps.service.StatisticService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class StatisticServiceTest {

    @Mock
    private StatisticRepository statisticRepository;
    private StatisticService statisticService;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        this.statisticService = new StatisticServiceImpl(statisticRepository);
    }

    @Test
    public void saveTest() {
        when(statisticRepository.save(any())).then(returnsFirstArg());

        GameResultDto resultDto = new GameResultDto(new User(), GameMove.SCISSORS,
                GameMove.PAPER, LocalDateTime.now(), GameResult.WIN);
        Statistic statistic = statisticService.save(resultDto);

        assertEquals(resultDto.getUserMove(), statistic.getUserMove());
        assertEquals(resultDto.getBotMove(), statistic.getBotMove());
        assertEquals(resultDto.getDate(), statistic.getDate());
        assertEquals(resultDto.getResult(), statistic.getResult());
    }
}