package com.tasif.pagination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasif.pagination.dto.EmployeeDto;
import com.tasif.pagination.model.Employee;
import com.tasif.pagination.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeDto employeeDto) {
		String response = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@PutMapping("/{employeeId}")
	public ResponseEntity<String> updateEmployee(@PathVariable long employeeId, @RequestBody EmployeeDto employeeDto) {
		String response = employeeService.updateEmployee(employeeId, employeeDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long employeeId) {
		String response = employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees(
			@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "employeeId") String sortBy) {
		List<Employee> list = employeeService.getAllEmployees(pageNo, pageSize, sortBy);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}
}
