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

@RestController
public class BillController {
	
	@Autowired
	private BillService billSer;
	
	@PostMapping("/Bills")
	public Bill addBill(@RequestBody Bill bill)
	{
		//also just in case they pass an id in json then set id=0
		//this is to force a save of new item...instead of update
		bill.setId(0);
		billSer.postBill(bill);
		return bill;
		
	}
	
	//mapping
	@PostMapping("/users/{id}/Bills")
	public Bill addBillUnderUser(@RequestBody Bill bill,@PathVariable String id)
	{
		//also just in case they pass an id in json then set id=0
		//this is to force a save of new item...instead of update
		bill.setId(0);
		//Users us=new Users();
		bill.setUser(new Users(id));
		billSer.AddBill(bill);
		return bill;
		
	}
	
	//mapping
			@GetMapping("/users/{id}/Bills")
			public List<Bill> getAllBillsByUserId(@PathVariable String id)
			{
				return billSer.getAllBillByUsersId(id);
			}
	
	@GetMapping("/Bills")
	public List<Bill> showBills()
	{
		return billSer.getBills();
	}
	
	@DeleteMapping("/Bills/{id}")
	public String deleteBill(@PathVariable int id)
	{
		Bill thebill=billSer.findById(id);
		if(thebill==null)
		{
			throw new RuntimeException("Employee id not found-" +id);
		}
		billSer.delBill(id);
		return "Deleted employee id " +id;
	}
	
	@GetMapping("/Bills/{id}")
	public Bill getBillByid(@PathVariable int id)
	{
		Bill theBill=billSer.findById(id);
		if(theBill==null)
		{
			throw new RuntimeException("Employee id not found-" +id);
		}
		return theBill;
	}
	
	
	
	@PutMapping("/Bills")
	public Bill updateBill(@RequestBody Bill bill)
	{
		billSer.postBill(bill);
		return bill;
	}
	
	

}
