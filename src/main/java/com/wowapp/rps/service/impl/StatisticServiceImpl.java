package com.wowapp.rps.service.impl;

import com.wowapp.rps.domain.dto.GameResultDto;
import com.wowapp.rps.domain.entity.Statistic;
import com.wowapp.rps.domain.entity.User;
import com.wowapp.rps.repository.StatisticRepository;
import com.wowapp.rps.service.StatisticService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    private final StatisticRepository statisticRepository;

    public StatisticServiceImpl(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Override
    @Transactional
    public Statistic save(GameResultDto gameResult) {
        Statistic statistic = new Statistic();
        statistic.setUser(gameResult.getUser());
        statistic.setUserMove(gameResult.getUserMove());
        statistic.setBotMove(gameResult.getBotMove());
        statistic.setResult(gameResult.getResult());
        statistic.setDate(gameResult.getDate());
        return statisticRepository.save(statistic);
    }

    @Override
    @Transactional
    public List<Statistic> getUserStatistic(User user) {
        return statisticRepository.findByUser(user);
    }

    @Override
    @Transactional
    public Page<Statistic> getUserStatistic(User user, Pageable pageable) {
        return statisticRepository.findByUser(user, pageable);
    }
}
