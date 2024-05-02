package com.ananya302.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ananya302.model.Employee;

@Repository
public class EmployeeImpl implements EmployeeDAO  
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int add(Employee employee) {
	    String sql = "INSERT INTO SupermarketInventorydb.employee(eid, ename, eemail, ephoneNumber, eaddress, dob, joinDate, endDate, salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    return jdbcTemplate.update(sql, 
	            employee.getEid(),
	            employee.getEname(), 
	            //employee.getDeptId(), 
	            employee.getEemail(),
	            employee.getEphoneNumber(),
	            employee.getEaddress(),
	            employee.getDob(),
	            employee.getJoinDate(),
	            employee.getEndDate(),
	            employee.getSalary());
	}

	@Override
	public int update(Employee employee, int eid) {
		String sql = "UPDATE SupermarketInventorydb.employee SET ename=?, eemail=?, ephoneNumber=?, eaddress=?, dob=?, joinDate=?, endDate=?, salary=? WHERE eid=?";
		return jdbcTemplate.update(sql, 
	            employee.getEname(), 
	            //employee.getDeptId(),
	            employee.getEemail(), 
	            employee.getEphoneNumber(), 
	            employee.getEaddress(), 
	            employee.getDob(), 
	            employee.getJoinDate(), 
	            employee.getEndDate(), 
	            employee.getSalary(),
	            eid);
	}

	@Override
	public int delete(int eid) {
		String sql = "DELETE FROM SupermarketInventorydb.employee WHERE eid=?";
		return jdbcTemplate.update(sql, eid);
	}

	@Override
	public List<Employee> getAll() {
		return jdbcTemplate.query("SELECT * FROM SupermarketInventorydb.employee", new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public Employee getById(int eid) {
		return jdbcTemplate.queryForObject("SELECT * FROM SupermarketInventorydb.employee WHERE eid = ?", new BeanPropertyRowMapper<>(Employee.class), eid);
	}
}
