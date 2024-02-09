package com.quiz.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.quiz.bean.Report;
import com.quiz.bean.Users;


@Repository
public interface ReportRepo extends JpaRepository<Report, Long>{
	
	  public Report getReportByUserId(long userId);
	
}
