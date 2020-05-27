package com.jkt.reimbursement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jkt.reimbursement.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

}
