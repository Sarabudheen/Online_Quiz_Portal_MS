package com.quiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.bean.Questions;

@Repository
public interface QuizRepo  extends JpaRepository<Questions, Long>{

	public List<Questions> getQuizByTopicId(long topicId);

}
