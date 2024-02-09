package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.bean.Questions;
import com.quiz.bean.Schedule;
import com.quiz.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
@CrossOrigin("http://localhost:4200/")
public class ScheduleController {

	@Autowired
	ScheduleService service;
	
	@PostMapping("/addTest")
	public void performAddTest(@RequestBody Schedule test) {
		service.addTest(test);
	}
	
	@PutMapping("/updateSchedule")
	public void performUpdateSchedule(@RequestBody Schedule test) {
		service.addTest(test);
	}
	
	@DeleteMapping("/deleteTest/{testId}")
	public void performDeleteTest(@PathVariable("testId") long testId) throws Exception {
		service.deleteTest(testId);
	}
	
//	@GetMapping("/getTest/{testId}")
//	public Questions performGetTestById(@PathVariable("testId") Long testId) throws Exception{
//		Questions quiz = service.get(testId);
//		return quiz;
//	}

	@GetMapping("/getAllTest")
	public List<Schedule> performGetAllTests() {
		List<Schedule> list = service.getAllTests();
		return list;
	}
}
