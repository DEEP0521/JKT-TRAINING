package com.jkt.reimbursement.controller;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
//import javax.ws.rs.core.MediaType;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.xml.ws.Response;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.annotations.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jkt.reimbursement.entity.Bill;
import com.jkt.reimbursement.entity.Users;

import com.jkt.reimbursement.service.BillService;

@RestController
public class BillController {
	
	@Autowired
	private BillService billSer;
	

	//@PostMapping(path="/Bills",consumes="multipart/form-data")
	//public Bill addBill(@ModelAttribute Bill bill)
	//{ 
		
//	  File convertfile  =new File(tempfile.getOriginalFilename());
//		System.out.println(convertfile);
//		convertfile.createNewFile();
//		FileOutputStream fout= new FileOutputStream(convertfile);
//		fout.write(((MultipartFile) convertfile).getBytes());
//		fout.close();
//		
//		
//		
//	     Bill n1=new Bill(bill.getType(),bill.getStart_date(),bill.getEnd_date(),);
		//also just in case they pass an id in json then set id=0
		//this is to force a save of new item...instead of update
		//bill.setId(0);
		//billSer.postBill(bill);
		//return bill;
		
		
	//}
	
	//mapping
	@PostMapping("/users/{id}/Bills")
	public Bill addBillUnderUser(@RequestBody Bill bill,@PathVariable String id,MultipartFile file)
	{
		//also just in case they pass an id in json then set id=0
		//this is to force a save of new item...instead of update
		bill.setId(0);
		//Users us=new Users();
		bill.setUser(new Users(id));
		billSer.AddBill(bill,file);
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
	//@GetMapping("/List")
	//public String showBills(Model themodel)
	{
		//List<Bill> bill=billSer.getBills();
		//themodel.addAttribute("bills",bill);
		return billSer.getBills();
		//return "showbills";
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
	
	//new Post Request with file 
	@PostMapping("/bills")
	public ResponseEntity<Object> AddBillWithFile(@ModelAttribute Bill bill,BindingResult result,@RequestParam("file") MultipartFile file)
	{
		billSer.AddBill(bill, file);
		return new ResponseEntity<>("JSON Along with File Uploaded",HttpStatus.OK);
	}
	
	
	//new downloading file
	
	@GetMapping(value="/downloadFile/{id}",produces=MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<Object> downloadFile(@PathVariable int id) throws FileNotFoundException
	{
		Bill b=billSer.getFile(id);
		return ResponseEntity.ok()
				       // .contentType(MediaType.parseMediaType(b.getType()))
				        .header("content-type", "multipart/form-data")
				        .header(HttpHeaders.CONTENT_DISPOSITION, "attachments;file=\"" +b.getType())
				        .body(new ByteArrayResource(b.getFile()));
		
					
	}

}
