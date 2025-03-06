package com.rajatraj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajatraj.dto.DepartmentDTO;
import com.rajatraj.dto.EmployeeDTO;
import com.rajatraj.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<EmployeeDTO> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	@CircuitBreaker(name = "employeeService", fallbackMethod = "fallbackGetEmployeeWithDepartment")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
		EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employeeDTO);
	}
	
	// Creating fall back method for circuitbreaker
	public ResponseEntity<EmployeeDTO> fallbackGetEmployeeWithDepartment(Long employeeId) {
		EmployeeDTO employee = new EmployeeDTO();
		employee.setId(employeeId);
		employee.setFirstName("Fallback");
		employee.setLastName("User");
		employee.setEmail("fallback@example.com");
		employee.setDepartmentId(1L);
	
		// Set a fallback department
		DepartmentDTO department = new DepartmentDTO();
		department.setDepartmentId(1L);
		department.setDepartmentName("Fallback Department");
		department.setDepartmentDescription("FALLBACK");
		department.setDepartmentCode("dummyCode");
		employee.setDepartment(department);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
		return ResponseEntity.ok(savedEmployee);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
		EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
}