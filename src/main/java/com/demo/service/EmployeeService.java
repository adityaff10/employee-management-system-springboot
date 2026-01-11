package com.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.demo.dto.EmployeeDTO;
import com.demo.exception.EmployeeNotFoundException;
import com.demo.model.Employee;
import com.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<EmployeeDTO> getAllEmployees() {
		logger.info("Fetching all employees from database");
		return employeeRepository.findAll().stream()
				.map(emp -> new EmployeeDTO(emp.getId(), emp.getName(), emp.getSalary())).collect(Collectors.toList());
	}

	public EmployeeDTO getEmployee(int id) {
		logger.info("Fetching employee with ID: {}", id);
		Employee emp = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException(id));
		return new EmployeeDTO(emp.getId(), emp.getName(), emp.getSalary());
	}

	public EmployeeDTO save(Employee employee) {
		logger.info("Saving employee: {}", employee.getName());
		Employee saved = employeeRepository.save(employee);
		return new EmployeeDTO(saved.getId(), saved.getName(), saved.getSalary());
	}

	public void delete(int id) {
		logger.warn("Attempting to delete employee with ID: {}", id);
		if (!employeeRepository.existsById(id)) {
			throw new EmployeeNotFoundException(id);
		}
		employeeRepository.deleteById(id);
		logger.info("Successfully deleted employee with ID: {}", id);
	}

}