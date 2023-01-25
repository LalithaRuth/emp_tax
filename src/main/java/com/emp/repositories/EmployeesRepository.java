package com.emp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.model.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
	List<Employees> findByEmployeeId(Long employeeId);
}
