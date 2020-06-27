package com.jkt.reimbursement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jkt.reimbursement.entity.Department;
import com.jkt.reimbursement.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
	List<Users> findByDepartmentId(Department department_id);
}
