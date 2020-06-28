package com.jkt.reimbursement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jkt.reimbursement.entity.Users;
import com.jkt.reimbursement.service.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService userSer;
		
	@CrossOrigin
	@GetMapping("/users/{id}")
	public Optional<Users> getuserById(@PathVariable String id)
	{
		return userSer.getByEmployeeId(id);			
	}
	
	@CrossOrigin
	@GetMapping("/admin/{id}")
	public List<Users> getforadmin(@PathVariable String id)
	{
		return userSer.getByadmin(id);			
	}
		
//	@GetMapping("/users")
//	public List<Users> showUsers()
//	{
//		return userSer.getUsers();
//	}

}
