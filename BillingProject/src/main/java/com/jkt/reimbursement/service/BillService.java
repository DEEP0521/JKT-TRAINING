package com.jkt.reimbursement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void AddBill(Bill bill)
	{
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

}
