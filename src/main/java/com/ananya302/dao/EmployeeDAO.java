package com.ananya302.dao;

import java.util.List;
import com.ananya302.model.Employee;

public interface EmployeeDAO {
	
	int add(Employee employee);
	
	int update(Employee employee, int eid);
	
	int delete(int eid);
	
	List<Employee> getAll();
	
	Employee getById(int eid);
}
