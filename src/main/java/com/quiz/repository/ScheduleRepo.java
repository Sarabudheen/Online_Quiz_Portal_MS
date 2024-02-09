package com.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.bean.Schedule;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Long>{

}
