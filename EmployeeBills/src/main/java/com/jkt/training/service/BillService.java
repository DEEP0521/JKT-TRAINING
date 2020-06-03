package com.jkt.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkt.training.entity.user_bill;
import com.jkt.training.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	BillRepository repo;
	
	public void saveBill(user_bill bill) {
		
		repo.save(bill);
	}
}
