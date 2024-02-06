package com.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.bean.Questions;
import com.quiz.bean.Topics;

@Repository
public interface TopicRepo extends JpaRepository<Topics, Long>{
	
}
