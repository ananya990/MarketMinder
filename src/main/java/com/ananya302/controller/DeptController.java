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
import com.ananya302.dao.DepartmentDAO; 
import com.ananya302.model.Department;

@RestController
@RequestMapping("/api")
public class DeptController 
{
    @Autowired
    private DepartmentDAO deptDAO;
    
    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return deptDAO.getAll();
    }
    
    @GetMapping("/departments/{deptId}")
    public Department getDepartmentById(@PathVariable("deptId") int deptId) {
        return deptDAO.getById(deptId);
    }
    
    @PostMapping("/departments")
    public String addDepartment(@RequestBody Department department) {
        int result = deptDAO.add(department);
        return result == 1 ? "Department added successfully" : "Failed to add department";
    }
    
    @PutMapping("/departments/{deptId}")
    public String updateDepartment(@RequestBody Department department, @PathVariable int deptId) {
        int result = deptDAO.update(department, deptId);
        return result == 1 ? "Department updated successfully" : "Failed to update department";
    }

    @DeleteMapping("/departments/{deptId}")
    public String deleteDepartment(@PathVariable int deptId) {
        int result = deptDAO.delete(deptId);
        return result == 1 ? "Department deleted successfully" : "Failed to delete department";
    }
}
