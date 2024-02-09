package com.quiz.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.bean.Login;
import com.quiz.bean.Topics;
import com.quiz.bean.Users;
import com.quiz.repository.UserRepo;
import com.quiz.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200/")
public class UserController {

	
	@Autowired
	UserService service;
	
	@PostMapping("/register")
	public String performRegisterUser(@RequestBody Users user) {
		service.registerUser(user);
		return "Registered Successfully";
	}

	@RequestMapping("/login")
	public ResponseEntity<?> performLogin(@RequestBody Users user) {
		Login res=service.login(user);
			return ResponseEntity.ok(res);
	}
	
	@PutMapping("/updateUser")
	public void performUpdateUser(@RequestBody Users user) {
		service.updateUser(user);
	}

	@DeleteMapping("/deleteUser/{userId}")
	public String performDeleteUser(@PathVariable("userId") long userId) throws Exception {
		service.deleteUser(userId);
		return "User Deleted Succefully";
	}
	
	@GetMapping("/getUserDetail/{userId}")
	public Users performGetUserById(@PathVariable("userId") Long userId) throws Exception{
		Users user = service.getUserById(userId);
		return user;
	}

	@GetMapping("/getAllUserDetails")
	public List<Users> performGetAllUsers() {
		List<Users> list = service.getAllUsers();
		return list;
	}
	
	@GetMapping("/getAllCandidates")
	public List<Users> performGetAllCandidates() {
		List<Users> list = service.getAllCandidates();
		return list;
	}
}
