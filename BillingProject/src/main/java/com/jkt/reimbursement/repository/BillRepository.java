package com.jkt.reimbursement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jkt.reimbursement.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {

	List<Bill> findByUserId(String username);
}
