package com.jkt.reimbursement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jkt.reimbursement.entity.Bill;
import com.jkt.reimbursement.service.BillService;

@RestController
public class BillController {
	
	@Autowired
	private BillService billSer;
	
	@PostMapping("/Bills")
	public String addBill(@RequestBody Bill bill)
	{
		billSer.postBill(bill);
		return "Bill Added";
		
	}
	
	@GetMapping("/Bills")
	public List<Bill> showBills()
	{
		return billSer.getBills();
	}
	
	@DeleteMapping("/Bills/{id}")
	public String deleteBill(@PathVariable int id)
	{
		billSer.delBill(id);
		return "Bill Deleted";
	}
>>>>>>> feature

import com.jkt.reimbursement.entity.User_Bill;
import com.jkt.reimbursement.service.BillService;

@RestController
public class BillController {
	@Autowired
	private BillService billSer;
	
	@GetMapping(path="/Bill")
	public List<User_Bill> showBill(){
		return billSer.getBill();
	}
	@PostMapping(path="/Bill",consumes = "application/json")
	public String  AddBill(@RequestBody User_Bill bil)
	{
		 billSer.postBill(bil);
		 return "Bill Added";
	}
}
