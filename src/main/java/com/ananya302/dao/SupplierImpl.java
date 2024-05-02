package com.ananya302.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ananya302.model.Supplier;

@Repository
public class SupplierImpl implements SupplierDAO {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int add(Supplier supplier) {
        String sql = "INSERT INTO SupermarketInventorydb.supplier(sid, sname, semail, saddress, sphoneNumber) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, 
                supplier.getSid(),
                supplier.getSname(), 
                supplier.getSemail(), 
                supplier.getSaddress(),
                supplier.getSphoneNumber());
    }

    @Override
    public int update(Supplier supplier, int sid) {
        String sql = "UPDATE SupermarketInventorydb.supplier SET sname=?, semail=?, saddress=?, sphoneNumber=? WHERE sid=?";
        return jdbcTemplate.update(sql, 
                supplier.getSname(), 
                supplier.getSemail(), 
                supplier.getSaddress(), 
                supplier.getSphoneNumber(), 
                sid);
    }

    @Override
    public int delete(int sid) {
        String sql = "DELETE FROM SupermarketInventorydb.supplier WHERE sid=?";
        return jdbcTemplate.update(sql, sid);
    }

    @Override
    public List<Supplier> getAll() {
        return jdbcTemplate.query("SELECT * FROM SupermarketInventorydb.supplier", new BeanPropertyRowMapper<Supplier>(Supplier.class));
    }

    @Override
    public Supplier getById(int sid) {
        return jdbcTemplate.queryForObject("SELECT * FROM SupermarketInventorydb.supplier WHERE sid=?", new BeanPropertyRowMapper<>(Supplier.class), sid);
    }
}
