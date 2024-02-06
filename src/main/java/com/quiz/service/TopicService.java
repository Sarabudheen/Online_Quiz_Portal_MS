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
	
	public boolean deleteTopics(Long topicId) throws Exception {
		repo.deleteById(topicId);
		return true;
	}
	
//	public Topics getTopicById(Long topicId) throws Exception{
//		System.out.println("Topic id requested from the user is "+topicId);
//		Optional<Topics> topic = repo.findById(topicId);
//		if(topic == null) {
//			throw new Exception("Topic not found exception");
//		}
//		System.out.println("Topic Details "+topic.getTopicId()+" "+topic.getTopicName());
//		return topic;
//	}
	
	public List<Topics> getAllTopics() {
		Iterator<Topics> it =  repo.findAll().iterator();
		List<Topics> list = new ArrayList<Topics>();
		
		while(it.hasNext()) {
			list.add(it.next());
		}
		
		return list;
	}

	public Optional<Topics> getTopicById(Long topicId) throws Exception {
		Optional<Topics> topic = repo.findById(topicId);
		return topic;
	}
}
