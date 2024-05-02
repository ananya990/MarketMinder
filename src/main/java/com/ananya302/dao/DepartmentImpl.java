package com.ananya302.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ananya302.model.Department;

@Repository
public class DepartmentImpl implements DepartmentDAO 
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int add(Department department) {
        String sql = "INSERT INTO SupermarketInventorydb.department(deptID, deptName, deptManager, eid) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, 
                department.getDeptID(), 
                department.getDeptName(), 
                department.getDeptManager(), 
                department.getEid());
    }

    @Override
    public int update(Department department, int deptID) {
        String sql = "UPDATE SupermarketInventorydb.department SET deptName=?, deptManager=?, eid=? WHERE deptID=?";
        return jdbcTemplate.update(sql, 
                department.getDeptName(), 
                department.getDeptManager(), 
                department.getEid(), 
                deptID);
    }

    @Override
    public int delete(int deptID) {
        String sql = "DELETE FROM SupermarketInventorydb.department WHERE deptID=?";
        return jdbcTemplate.update(sql, deptID);
    }

    @Override
    public List<Department> getAll() {
        return jdbcTemplate.query("SELECT * FROM SupermarketInventorydb.department", new BeanPropertyRowMapper<>(Department.class));
    }

    @Override
    public Department getById(int deptID) {
        return jdbcTemplate.queryForObject("SELECT * FROM SupermarketInventorydb.department WHERE deptID = ?", new BeanPropertyRowMapper<>(Department.class), deptID);
    }
}
