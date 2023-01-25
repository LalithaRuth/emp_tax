package com.emp.service;

import java.util.List;

import com.emp.model.Employees;

public interface EmployeeService {
	public boolean saveEmpProfile(Employees emp);
	public List<Employees> getEmpTaxDeductions();
}
