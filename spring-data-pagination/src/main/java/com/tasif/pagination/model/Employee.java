package com.tasif.pagination.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;

@Entity
@Table
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employeeId;
	
	private String employeeName;
	
	@Email
	private String employeeEmail;
	
	private long employeeMobile;
	
	private short employeeAge;
	
	private int employeeSalary;
}
