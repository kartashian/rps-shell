package com.wowapp.rps.service;

import com.wowapp.rps.domain.dto.GameResultDto;
import com.wowapp.rps.domain.entity.Statistic;
import com.wowapp.rps.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StatisticService {

    /**
     * Save game result as statistic
     * @param gameResult game result
     * @return statistic entity
     */
    Statistic save(GameResultDto gameResult);

    /**
     * Return all user games statistic
     * @param user user
     * @return statistic list
     */
    List<Statistic> getUserStatistic(User user);

    /**
     * Return user games statistic by pages
     * @param user user
     * @return statistic page
     */
    Page<Statistic> getUserStatistic(User user, Pageable pageable);
}
