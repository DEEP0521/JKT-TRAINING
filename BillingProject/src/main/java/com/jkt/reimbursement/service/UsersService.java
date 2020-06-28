package com.jkt.reimbursement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkt.reimbursement.entity.Users;
import com.jkt.reimbursement.exception.GlobalException;
import com.jkt.reimbursement.repository.UsersRepository;


@Service
public class UsersService {
	
	@Autowired
	private UsersRepository userRepo;
	
	public Optional<Users> getByEmployeeId(String id)
	{
		Optional<Users> empId=userRepo.findById(id);
		if(empId.isPresent()) {
			return userRepo.findById(id);
		}
		else
			throw new GlobalException("Employee Record not Found!");
	}
	
	public List<Users> getByadmin(String id) {
		
		List<Users> empId=userRepo.findByLineManager(id);
		if(empId.isEmpty()==false) {
			return userRepo.findByLineManager(id);
		}
		else
			throw new GlobalException("Employee Record not Found!");
	}
	
//	public List<Users> getUsers()
//	{
//		return userRepo.findAll();
//		
//	}

}
