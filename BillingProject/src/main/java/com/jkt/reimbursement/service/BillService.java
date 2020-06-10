package com.jkt.reimbursement.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		billRepo.delete(bill);
	}
	
	public Bill findById(int id)
	{
	Optional<Bill> result=billRepo.findById(id);
	
	Bill thebill=null;
	if(result.isPresent())
	{
		thebill=result.get();
	}
	return thebill;
	}
	
	//mapping find bill by username 
		public List<Bill> getAllBillByUsersId(String username)
		{
			List<Bill> bill=new ArrayList<>();
			billRepo.findByUserId(username).forEach(bill::add);
			return bill;
		}

		
		//new for file
		public Bill getFile(int id) throws FileNotFoundException {
			return billRepo.findById(id)
					.orElseThrow(()->new FileNotFoundException("File not found with id" +id));
		}
}
