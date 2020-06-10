package com.jkt.reimbursement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jkt.reimbursement.entity.Bill;
import com.jkt.reimbursement.service.BillService;

@RestController
public class BillController {
	
	@Autowired
	private BillService billSer;
	
	
	//Controller Method
	
		@PostMapping(path= "/Bills")
		@ResponseBody
		public ResponseEntity<Object> addBillUnderUser(@ModelAttribute Bill bill,BindingResult result,
				@ModelAttribute("file") MultipartFile file) 
		{
			billSer.AddBill(bill,file);
			return new ResponseEntity<> ("File Uploaded",HttpStatus.OK);
		}

		
		
	//mapping
	@GetMapping("/users/{id}/Bills")
	public List<Bill> getAllBillsByUserId(@PathVariable String id)
	{
		return billSer.getAllBillByUsersId(id);
	}
	
	@GetMapping(path = "/Bills",produces = {"application/pdf","text/plain"})
	@CrossOrigin
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
