package com.example.controller;


import java.util.List;

import com.example.exceptions.IdNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RestController;
import com.example.entiity.Product;
import com.example.service.ServiceClass;

@RestController
@RequestMapping("/employees")
@CrossOrigin("http://localhost:4200")

public class ControllerClass {

	@Autowired
	ServiceClass serviceobj;

	// Create Employee
	@PostMapping("/EmployeeCreation")
	public ResponseEntity<String> ProductCreation(@RequestBody Product emp) {
		Product e = serviceobj.ProductCreation(emp);
		if (e == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("Employee created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Get Particular Employee Data
	@GetMapping("/GetEmployee/{id}")
	private ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
		Product e = serviceobj.getProductById(id);
		if (e == null) {
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		} else {
			return new ResponseEntity<Product>(e, new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Get All Employees Data
	@GetMapping("/GetAllEmployees")
	private ResponseEntity<List<Product>> getAllEmployee() {
		List<Product> emplist = serviceobj.getAllEmployee();
		return new ResponseEntity<List<Product>>(emplist, new HttpHeaders(), HttpStatus.OK);

	}

	// Updating Employee data
	@PutMapping("/UpdateEmployee")
	public ResponseEntity<String> UpdateEmployee(@RequestBody Product emp) {
		Product e = serviceobj.UpdateEmployee(emp);
		if (e == null) {
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Product updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Deleting Employee
	@DeleteMapping("/DeleteEmployee/{id}")
	private ResponseEntity<String> delEmp(@PathVariable("id") int id) {
		Product e = serviceobj.delete(id);
		if (e == null) {
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Employee deleted successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
