package com.jkt.reimbursement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkt.reimbursement.entity.Users;
import com.jkt.reimbursement.repository.UsersRepository;


@Service
public class UsersService {
	
	@Autowired
	private UsersRepository userRepo;
	
	
	public List<Users> getUsers()
	{
		return userRepo.findAll();
		
	}
	
	public Users findById(String id)
	{
		Optional<Users> result=userRepo.findById(id);
		Users theuser=null;
		if(result.isPresent())
		{
			theuser=result.get();
		}
		return theuser;
	}
	
	
	/*
	 * public Users findById(int id) { Optional<Users> result=userRepo.findById(id);
	 * 
	 * Users theuser=null; if(result.isPresent()) { theuser=result.get(); } return
	 * theuser; }
	 */
}
