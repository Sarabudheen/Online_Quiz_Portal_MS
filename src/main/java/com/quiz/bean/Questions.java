package com.quiz.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_questions")
public class Questions {
	
	@Id
	@Column(name = "Quiz_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long quizId;
	
	@Column(name = "Topic_Id")
	private long topicId;
	
	@Column(name = "Quiz")
	private String quiz;
	
	@Column(name = "First_Option")
	private String firstOption;
	
	@Column(name = "Second_Option")
	private String secondOption;
	
	@Column(name = "Third_Option")
	private String thirdOption;
	
	@Column(name = "Fourth_Option")
	private String fourthOption;
	
	@Column(name = "Answer")
	private String answer;

	/**
	 * 
	 */
	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param quizId
	 * @param topicId
	 * @param quiz
	 * @param firstOption
	 * @param secondOption
	 * @param thirdOption
	 * @param fourthOption
	 * @param answer
	 */
	public Questions(long quizId, long topicId, String quiz, String firstOption, String secondOption,
			String thirdOption, String fourthOption, String answer) {
		super();
		this.quizId = quizId;
		this.topicId = topicId;
		this.quiz = quiz;
		this.firstOption = firstOption;
		this.secondOption = secondOption;
		this.thirdOption = thirdOption;
		this.fourthOption = fourthOption;
		this.answer = answer;
	}

	public long getQuizId() {
		return quizId;
	}

	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}

	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	public String getQuiz() {
		return quiz;
	}

	public void setQuiz(String quiz) {
		this.quiz = quiz;
	}

	public String getFirstOption() {
		return firstOption;
	}

	public void setFirstOption(String firstOption) {
		this.firstOption = firstOption;
	}

	public String getSecondOption() {
		return secondOption;
	}

	public void setSecondOption(String secondOption) {
		this.secondOption = secondOption;
	}

	public String getThirdOption() {
		return thirdOption;
	}

	public void setThirdOption(String thirdOption) {
		this.thirdOption = thirdOption;
	}

	public String getFourthOption() {
		return fourthOption;
	}

	public void setFourthOption(String fourthOption) {
		this.fourthOption = fourthOption;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	
	
}
