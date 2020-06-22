package com.jkt.reimbursement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jkt.reimbursement.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

	List<Bill> findByUserId(String username);
}
