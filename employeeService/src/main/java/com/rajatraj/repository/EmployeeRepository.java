package com.rajatraj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajatraj.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}