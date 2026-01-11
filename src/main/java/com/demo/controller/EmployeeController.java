package com.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.demo.dto.EmployeeDTO;
import com.demo.model.Employee;
import com.demo.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/employees")
@Tag(name = "Employee Management", description = "APIs for managing employees")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Operation(summary = "Get all employees", description = "Retrieves a list of all employees")
	@ApiResponse(responseCode = "200", description = "Successfully retrieved list")
	@GetMapping
	public List<EmployeeDTO> getAllEmployees() {
		logger.info("Fetching all employees");
		return employeeService.getAllEmployees();
	}

	@Operation(summary = "Get employee by ID", description = "Retrieves a single employee by their ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved employee"),
        @ApiResponse(responseCode = "404", description = "Employee not found")
    })
	@GetMapping("/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable int id) {
		logger.info("Fetching employee with ID: {}", id);
		return employeeService.getEmployee(id);
	}

	@Operation(summary = "Create or update employee", description = "Creates a new employee or updates an existing one")
	    @ApiResponses(value = {
	    @ApiResponse(responseCode = "201", description = "Employee created successfully"),
	    @ApiResponse(responseCode = "400", description = "Invalid input data")
	})
	@PostMapping
	public EmployeeDTO insertOrUpdateEmployee(@Valid @RequestBody Employee employee) {
		logger.info("Inserting or updating employee: {}", employee.getName());
		return employeeService.save(employee);
	}

	@Operation(summary = "Delete employee", description = "Deletes an employee by their ID")
	    @ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Employee deleted successfully"),
	    @ApiResponse(responseCode = "404", description = "Employee not found")
	})
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable int id) {
		logger.warn("Deleting employee with ID: {}", id);
		employeeService.delete(id);
		return "Employee deleted successfully.";
	}

}