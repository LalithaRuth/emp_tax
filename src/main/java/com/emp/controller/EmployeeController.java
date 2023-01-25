package com.emp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.emp.model.Employees;
import com.emp.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	@PostMapping("/saveEmplyee")
	public View saveEmplyee(@Valid @RequestBody Employees emp, Model model) {
		try {
			empService.saveEmpProfile(emp);
		} catch(Exception e) {
			model.addAttribute("status", "Unable to create Profile.");
			e.printStackTrace();
		}
		model.addAttribute("status", "Profile created successfully.");
		return new MappingJackson2JsonView();
	}
	
	@GetMapping("/getEmpTaxDeductions")
	public View getEmpTaxDeductions(Model model) {
		List<Employees> empTaxDeds = empService.getEmpTaxDeductions();
		model.addAttribute("empTaxDeds", empTaxDeds);
		return new MappingJackson2JsonView();
	}
}
