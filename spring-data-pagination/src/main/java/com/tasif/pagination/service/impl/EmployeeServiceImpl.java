package com.tasif.pagination.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tasif.pagination.dto.EmployeeDto;
import com.tasif.pagination.model.Employee;
import com.tasif.pagination.repository.EmployeeRepository;
import com.tasif.pagination.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String createEmployee(EmployeeDto employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		employeeRepository.save(employee);
		return "Employee created successfully";
	}

	@Override
	public String updateEmployee(long employeeId, EmployeeDto employeeDto) {
		Employee employee = employeeRepository.findById(employeeId).get();
		employee.setEmployeeName(employeeDto.getEmployeeName());
		employee.setEmployeeEmail(employeeDto.getEmployeeEmail());
		employee.setEmployeeMobile(employeeDto.getEmployeeMobile());
		employee.setEmployeeAge(employeeDto.getEmployeeAge());
		employee.setEmployeeSalary(employeeDto.getEmployeeSalary());
		employeeRepository.save(employee);
		return "Employee updated successfully";
	}

	@Override
	public String deleteEmployee(long employeeId) {
		employeeRepository.deleteById(employeeId);
		return "Employee deleted successfully";
	}

	@Override
	public List<Employee> getAllEmployees(int pageNo, int pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Employee> pagedResult = employeeRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Employee>();
		}
	}

}
