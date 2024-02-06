package com.quiz.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.quiz.bean.Report;


@Repository
public interface ReportRepo extends JpaRepository<Report, Long>{
	
}
