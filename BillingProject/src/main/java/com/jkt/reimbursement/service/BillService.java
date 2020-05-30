package com.jkt.reimbursement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkt.reimbursement.entity.User_Bill;
import com.jkt.reimbursement.repository.BillRepository;

@Service
public class BillService {
	
	@Autowired
	private BillRepository billRepo;
	
	public void postBill(User_Bill bill)
	{
		billRepo.save(bill);
	}
	
	public List<User_Bill> getBills()
	{
		return billRepo.findAll();
		
	}
	
	public void delBill(int id)
	{
		User_Bill bill=billRepo.getOne(id);
		billRepo.delete(bill);
	}

}
