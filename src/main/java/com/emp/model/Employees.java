package com.emp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

@Table(name="employees")
@Entity
public class Employees implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date doj;
	private Float salary;
	@Transient
	private Float yearlySalary;
	@Transient
	private Float taxAmount;
	@Transient
	private Float cessAmount;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Transient
	public Float getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(Float taxAmount) {
		this.taxAmount = taxAmount;
	}
	@Transient
	public Float getCessAmount() {
		return cessAmount;
	}
	public void setCessAmount(Float cessAmount) {
		this.cessAmount = cessAmount;
	}
	@Transient
	public Float getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(Float yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	
	
	
}
