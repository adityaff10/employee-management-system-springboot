package com.demo.exception;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends RuntimeException {
	
    public EmployeeNotFoundException(String message) {
        super(message);
    }
    
    public EmployeeNotFoundException(int id) {
        super("Employee not found with ID: " + id);
    }
    
}