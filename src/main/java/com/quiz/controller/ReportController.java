package com.quiz.controller;

import java.util.List;
import java.util.Optional;

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

import com.quiz.bean.Report;
import com.quiz.bean.Users;
import com.quiz.service.ReportService;

@RestController
@RequestMapping("/reports")
@CrossOrigin("http://localhost:4200/")
public class ReportController {
	@Autowired
	ReportService service;
	
	@PostMapping("/addReport")
	public void performAddReport(@RequestBody Report report) {
		service.addReport(report);
	}
	
	@PutMapping("/updateReport")
	public void performUpdateReport(@RequestBody Report report) {
		service.addReport(report);
	}
	@DeleteMapping("/deleteReport/{reportId}")
	public void performDeleteReport(@PathVariable("reportId") long reportId) throws Exception {
		service.deleteReport(reportId);
	}
	
	@GetMapping("/getReportDetail/{reportId}")
	public Report performGetReportById(@PathVariable("reportId") Long reportId) throws Exception{
		Report report = service.getReportById(reportId);
		return report;
	}

	@GetMapping("/getReportDetailByUserId/{userId}")
	public Report performGetReportByUserId(@PathVariable("userId") Long userId) throws Exception{
		Report report = service.getReportByUserId(userId);
		return report;
	}
	
	@GetMapping("/getAllReportDetails")
	public List<Report> performGetAllUsers() {
		List<Report> list = service.getAllReport();
		return list;
	}

}
