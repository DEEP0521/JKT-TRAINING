package com.jkt.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jkt.training.entity.user_bill;
import com.jkt.training.service.BillService;

@RestController
public class BillController {
	
	@Autowired
	BillService service;
	
	@PostMapping(path = "/Bills",consumes="multipart/form-data")
	public String addBill(@ModelAttribute user_bill bill) {
		service.saveBill(bill);
		return "Bill Added";
	}
}
