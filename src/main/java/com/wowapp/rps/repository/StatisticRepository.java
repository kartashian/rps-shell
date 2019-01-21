package com.wowapp.rps.repository;

import com.wowapp.rps.domain.entity.Statistic;
import com.wowapp.rps.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {

    List<Statistic> findByUser(User user);

    Page<Statistic> findByUser(User user, Pageable pageable);
}
