package com.quiz.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.bean.Topics;
import com.quiz.bean.Users;
import com.quiz.repository.TopicRepo;

@Service
public class TopicService {

	@Autowired
	TopicRepo repo;
	
	public boolean addTopic(Topics topic) {
		repo.save(topic);
		return true;
	}
	
	public boolean update(Topics topic) {
		repo.save(topic);
		return true;
	}
	
	
	public boolean deleteTopics(Long topicId) {
		repo.deleteById(topicId);
		return true;
	}
	
	
	public List<Topics> getAllTopics() {
		Iterator<Topics> it =  repo.findAll().iterator();
		List<Topics> list = new ArrayList<Topics>();
		
		while(it.hasNext()) {
			list.add(it.next());
		}
		
		return list;
	}

	public Topics getTopicById(Long topicId) {
		Topics topic = repo.findById(topicId).get();
		return topic;
	}
}
