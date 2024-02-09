package com.quiz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.quiz.bean.Questions;
import com.quiz.bean.Users;
import com.quiz.repository.UserRepo;
import com.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("http://localhost:4200/")
public class QuizController {

	
	@Autowired
	QuizService service;
	
	@PostMapping("/addQuiz")
	public  ResponseEntity<String> performaddQuiz(@RequestPart("file") MultipartFile file) {
		 try {
			 
			 service.addQuiz(file);
		 }catch(Exception e){
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
		 }return ResponseEntity.ok("File uploaded successfully");
	}
	
	@PutMapping("/updateQuiz")
	public void performUpdateQuiz(@RequestBody Questions quiz) {
		service.updateQuiz(quiz);
	}

	@DeleteMapping("/deleteQuiz/{quizId}")
	public void performDeleteQuiz(@PathVariable("quizId") long quizId) throws Exception {
		service.deleteQuiz(quizId);
	}
	
	@GetMapping("/getQuiz/{quizId}")
	public Questions performGetQuizById(@PathVariable("quizId") Long quizId) throws Exception{
		Questions quiz = service.getQuizById(quizId);
		return quiz;
	}

	@GetMapping("/getAllQuizzes")
	public List<Questions> performGetAllQuiz() {
		List<Questions> list = service.getAllQuizzes();
		return list;
	}
	
	@GetMapping("/getQuizByTopicId/{topicId}")
	public List<Questions> performgetQuizById(@PathVariable("topicId") long topicId) {
		List<Questions> list = service.getQuizByTopicId(topicId);
		return list;
	}
	

}
