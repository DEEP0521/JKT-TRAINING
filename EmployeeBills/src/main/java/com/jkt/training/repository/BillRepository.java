package com.jkt.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jkt.training.entity.user_bill;

public interface BillRepository extends JpaRepository<user_bill, Integer> {

}
