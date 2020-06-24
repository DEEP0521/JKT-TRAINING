package com.jkt.reimbursement.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jkt.reimbursement.entity.Bill;
import com.jkt.reimbursement.service.BillService;

@RestController
public class BillController {
	
	@Autowired
	private BillService billSer;
	
	@CrossOrigin
	@GetMapping("/Bills/{userId}")
	public List<Bill> getBillByid(@PathVariable int userId)
	{
		String chId=String.valueOf(userId);
		List<Bill> theBill=billSer.getAllBillByUsersId(chId);
		if(theBill==null)
		{
			throw new RuntimeException("Employee id not found-" +userId);
		}
		return theBill;
	}
	
	@PostMapping("/users/{id}/bills")
	public ResponseEntity<Object> AddBillWithFile(@ModelAttribute Bill bill,BindingResult result,
			@RequestParam("file") MultipartFile file)
	{
		billSer.AddBill(bill, file);
		return new ResponseEntity<>("JSON Along with File Uploaded",HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value="/downloadFile/{id}",produces=MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<Object> downloadFile(@PathVariable int id) throws FileNotFoundException
	{
		System.out.println(id);
		Bill b=billSer.getFile(id);
		return ResponseEntity.ok()
				       // .contentType(MediaType.parseMediaType(b.getType()))
				        .header("content-type", "multipart/form-data")
				        .header(HttpHeaders.CONTENT_DISPOSITION, "attachments;file=\"" +b.getType())
				        .body(new ByteArrayResource(b.getFile()));
		
					
	}

	@CrossOrigin
	@DeleteMapping("/Bills/{id}")
	public void deleteBill(@PathVariable int id)
	{
		billSer.delBill(id);
	}
	
	@CrossOrigin
	@PutMapping("/Bills/{id}")
	public void updateBill(@RequestBody Bill bill,@PathVariable int id)
	{
		billSer.updateBill(bill,id);
	}
	

}
