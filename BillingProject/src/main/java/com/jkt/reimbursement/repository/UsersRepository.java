package com.jkt.reimbursement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jkt.reimbursement.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

}
