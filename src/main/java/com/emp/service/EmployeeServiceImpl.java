package com.emp.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.Employees;
import com.emp.repositories.EmployeesRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeesRepository empRepo;
	
	final Float SALARY_RANGE1 = (float) 250000;
	final Float SALARY_RANGE2 = (float) 500000;
	final Float SALARY_RANGE3 = (float) 750000;
	final Float SALARY_RANGE4 = (float) 1000000;
	
	@Override
	public boolean saveEmpProfile(Employees emp) {
		empRepo.save(emp);
		return true;
	}
	@Override
	public List<Employees> getEmpTaxDeductions() {        
		List<Employees> empTaxDeductions = Collections.emptyList();
		empTaxDeductions = empRepo.findAll();
		for(Employees emp : empTaxDeductions) {
			float annualSal = emp.getSalary()*12;
			float ded = calculateTax(annualSal);
			emp.setYearlySalary(annualSal);
			emp.setTaxAmount(ded);			
			if( annualSal > SALARY_RANGE1) {
				float cess = (annualSal - SALARY_RANGE1)/100*2;
				emp.setCessAmount(cess);
			}	
		}
		return empTaxDeductions;
	}
	
	private float calculateTax(Float salary) {
		float dedAmt = 0;
		if(salary <= SALARY_RANGE1) {
			dedAmt = 0;
		} else if (salary > SALARY_RANGE1 && salary <= SALARY_RANGE2) {
			dedAmt = salary/100*5; //5% Tax for >250000 and <=500000
		} else if (salary> SALARY_RANGE2 && salary <= SALARY_RANGE3) {
			dedAmt = SALARY_RANGE2/100*5; //5% Tax for >250000 and <=500000
			float remaingAmt = (salary-SALARY_RANGE2)/100*5;
			dedAmt+=remaingAmt;
		} else {
			dedAmt = SALARY_RANGE2/100*5; //5% Tax for >250000 and <=500000
			float remaingAmt = SALARY_RANGE3/100*5;
			float remaingAmt2 = (salary-SALARY_RANGE3)/100*5;	
			dedAmt+= remaingAmt + remaingAmt2;

		}
		return dedAmt;
	}

}
