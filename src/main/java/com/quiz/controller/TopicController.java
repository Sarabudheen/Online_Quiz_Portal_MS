package com.quiz.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.bean.Topics;
import com.quiz.bean.Users;
import com.quiz.service.TopicService;

@RestController
@RequestMapping("/topics")
@CrossOrigin("http://localhost:4200/")
public class TopicController {

	@Autowired
	TopicService service;
	
	@PostMapping("/addTopic")
	public void performAddTopic(@RequestBody Topics topic) {
		service.addTopic(topic);
	}
	
	@DeleteMapping("/deleteTopic/{topicId}")
	public void performDeleteTopic(@PathVariable("topicId") long topicId) throws Exception {
		service.deleteTopics(topicId);
	}
	
	@GetMapping("/getTopic/{topicId}")
	public Topics performGetTopicById(@PathVariable("topicId") Long topicId) throws Exception{
		Topics topic = service.getTopicById(topicId);
		return topic;
	}

	@GetMapping("/getAllTopics")
	public List<Topics> performGetAllTopics() {
		List<Topics> list = service.getAllTopics();
		return list;
	}
	
	@PutMapping("/updateTopic")
	public void performUpdateTopic(@RequestBody Topics topic) {
		service.update(topic);
	}
	
}
