package com.quiz.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.bean.Report;
import com.quiz.bean.Users;
import com.quiz.repository.ReportRepo;

@Service
public class ReportService {

	@Autowired
	ReportRepo repo;
	
	public boolean addReport(Report report) {
		repo.save(report);
		return true;
	}

	public boolean deleteReport(Long reportId) throws Exception {
		repo.deleteById(reportId);
		return true;
	}
	
	public List<Report> getAllReport() {
		Iterator<Report> it =  repo.findAll().iterator();
		List<Report> list = new ArrayList<Report>();
		
		while(it.hasNext()) {
			list.add(it.next());
		}
		
		return list;
	}

	public Optional<Report> getReportById(Long reportId) throws Exception {
		Optional<Report> report = repo.findById(reportId);
		return report;
	}
}
