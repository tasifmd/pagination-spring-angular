package com.tasif.pagination.service;

import java.util.List;

import com.tasif.pagination.dto.EmployeeDto;
import com.tasif.pagination.model.Employee;

public interface EmployeeService {
	
	public String createEmployee(EmployeeDto employeeDto);
	public String updateEmployee(long employeeId, EmployeeDto employeeDto);
	public String deleteEmployee(long employeeId);
	public List<Employee> getAllEmployees(int pageNo, int pageSize, String sortBy);
}
