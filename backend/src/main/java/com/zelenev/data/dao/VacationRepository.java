package com.zelenev.data.dao;

import com.zelenev.data.entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, Integer> {

    List<Vacation> findVacationsByAccountId(Integer id);
}
