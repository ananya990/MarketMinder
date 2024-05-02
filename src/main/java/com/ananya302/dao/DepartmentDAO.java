package com.ananya302.dao;

import java.util.List;
import com.ananya302.model.Department;

public interface DepartmentDAO 
{
	int add(Department department);
    
	int update(Department department, int deptID);
    
	int delete(int deptID);
    
	List<Department> getAll();
    
	Department getById(int deptID);
}
