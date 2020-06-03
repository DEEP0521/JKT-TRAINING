package com.jkt.reimbursement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jkt.reimbursement.entity.Bill;
import com.jkt.reimbursement.service.BillService;

@RestController
public class BillController {
	
	@Autowired
	private BillService billSer;
	
	//Controller Method
	
		@PostMapping(path= "/Bills",consumes = "multipart/form-data")
		public void addBillUnderUser(@ModelAttribute Bill bill,BindingResult result) 
		{
			System.out.println(bill.getUser()+"\n"+bill.getFile());
			billSer.AddBill(bill);
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
	

}
