package com.quiz.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.quiz.bean.Questions;
import com.quiz.bean.Users;
import com.quiz.repository.QuizRepo;

@Service
public class QuizService {

	@Autowired
	QuizRepo repo;

	public boolean addQuiz(MultipartFile file) throws IOException {

		byte[] fileContent = file.getBytes();
		FileOutputStream fout = new FileOutputStream("JavaOnlineQuiz.xlsx");
		fout.write(fileContent);
		fout.close();
		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		XSSFSheet sheet = workbook.getSheetAt(0);
		for (int rowIndex = 0; rowIndex < 20; rowIndex++) {
			XSSFRow row = sheet.getRow(rowIndex);

			if (row != null) {
				Questions data = new Questions();

				String t1 = row.getCell(0).toString();
				String t2 = row.getCell(1).toString();

				long quizId = Long.parseLong(t1.substring(0, t1.indexOf('.')));
				data.setQuizId(quizId);

				long topicId = Long.parseLong(t2.substring(0, t2.indexOf('.')));
				data.setTopicId(topicId);

				String quiz = row.getCell(2).toString();
				data.setQuiz(quiz);

				String firstOption = row.getCell(3).toString();
				data.setFirstOption(firstOption);

				String secondOption = row.getCell(4).toString();
				data.setSecondOption(secondOption);

				String thirdOption = row.getCell(5).toString();
				data.setThirdOption(thirdOption);

				String fourthOption = row.getCell(6).toString();
				data.setFourthOption(fourthOption);

				String answer = row.getCell(7).toString();
				data.setAnswer(answer);

				repo.save(data);
			} else {
				System.out.println("Row is null at index:" + rowIndex);
			}
		}
		return true;
	}
	
	public boolean deleteQuiz(Long quizId) throws Exception {
		repo.deleteById(quizId);
		return true;
	}
	
	public List<Questions> getAllQuizzes() {
		Iterator<Questions> it =  repo.findAll().iterator();
		List<Questions> list = new ArrayList<Questions>();
		
		while(it.hasNext()) {
			list.add(it.next());
		}
		
		return list;
	}

	public Questions getQuizById(Long quizId) throws Exception {
		Questions quiz = repo.findById(quizId).get();
		return quiz;
	}
	
	public List<Questions> getQuizByTopicId(long topicId) {
		Iterator<Questions> it =  repo.getQuizByTopicId(topicId).iterator();
		List<Questions> list = new ArrayList<Questions>();
		
		while(it.hasNext()) {
			list.add(it.next());
		}
		
		return list;
	}
	
}
