package com.jkt.reimbursement.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jkt.reimbursement.entity.Bill;
import com.jkt.reimbursement.repository.BillRepository;


@Service
public class BillService {
	
	@Autowired
	private BillRepository billRepo;
	
	public void postBill(Bill bill)
	{
		billRepo.save(bill);
	}
	
	public void updateBill(Bill bill,int id)
	{
		Bill b1=billRepo.findById(id);
		if(!b1.equals(null))
		{
			b1.setRemark(bill.getRemark());
			billRepo.save(b1);
		}
		else
			throw new RuntimeException("Bill not found-" +id);
	}
	//mapping add bill user/bill
	public void AddBill(Bill bill,MultipartFile file)
	{
		try {
			bill.setFile(file.getBytes());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		billRepo.save(bill);
	}
	
	
	public List<Bill> getBills()
	{
		return billRepo.findAll();
		
	}
	
	public void delBill(int id)
	{
		Bill bill=billRepo.getOne(id);
		if(!bill.equals(null)) {
			billRepo.delete(bill);
		}
		else
			throw new RuntimeException("Bill not found-" +id);
	}
	
	//mapping find bill by username 
	public List<Bill> getAllBillByUsersId(String username)
	{
		List<Bill> bill=new ArrayList<>();
		billRepo.findByUserId(username).forEach(bill::add);
		return bill;
	}
		
	//new for file
	public Bill getFile(int id) throws FileNotFoundException 
	{
		Bill b1=billRepo.findById(id);
		if(!b1.equals(null)) {
			return billRepo.findById(id);
		}
		else
			throw new RuntimeException("File not found-" +id);
	}
}
