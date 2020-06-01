package com.jkt.reimbursement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jkt.reimbursement.entity.Bill;
import com.jkt.reimbursement.entity.Users;
import com.jkt.reimbursement.service.BillService;
import com.jkt.reimbursement.service.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService userSer;
	
	
	
	@GetMapping("/users")
	public List<Users> showUsers()
	{
		return userSer.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public Users getuserById(@PathVariable String id)
	{
		Users user=userSer.findById(id);
		if(user==null)
		{
			throw new RuntimeException("User not found with id " +id);
		}
		return user;
	}
}
