package com.ananya302.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import com.ananya302.dao.EmployeeDAO; 
import com.ananya302.model.Employee;

@RestController
@RequestMapping("/api")
public class EmpController 
{
	@Autowired
	private EmployeeDAO eDAO;
	
	@GetMapping("/employees")
	public List<Employee> getEmployee(){
		return eDAO.getAll();
	}
	
	@GetMapping("/employees/{eid}")
	public Employee getEmployeeById(@PathVariable("eid") int eid) {
		return eDAO.getById(eid);
	}
	
	@PostMapping("/employees")
	public String addEmployee(@RequestBody Employee employee) {
		int result = eDAO.add(employee);
		return result == 1 ? "Employee added successfully" : "Failed to add employee";
	}
	
	@PutMapping("/employees/{eid}")
	public String updateEmployee(@RequestBody Employee employee, @PathVariable int eid) {
		int result = eDAO.update(employee, eid);
		return result == 1 ? "Employee updated successfully" : "Failed to update employee";
	}

	@DeleteMapping("/employees/{eid}")
	public String deleteEmployee (@PathVariable int eid) {
		int result = eDAO.delete(eid) ;
		return result == 1 ? "Employee deleted successfully" : "Failed to delete employee";
	}
}