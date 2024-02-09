package com.quiz.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.bean.Schedule;
import com.quiz.repository.ScheduleRepo;


@Service
public class ScheduleService {
	
	@Autowired
	ScheduleRepo repo;
	
	public List<Schedule> getAllTests() {
		Iterator<Schedule> it =  repo.findAll().iterator();
		List<Schedule> list = new ArrayList<Schedule>();
		
		while(it.hasNext()) {
			list.add(it.next());
		}
		
		return list;
	}
	
	public boolean updateSchedule(Schedule Schedule) {
		repo.save(Schedule);
		return true;
	}
	public boolean deleteTest(Long testId) {
		repo.deleteById(testId);
		return true;
	}
	
	public boolean addTest(Schedule schedule) {
		repo.save(schedule);
		return true;
	}
	

}
