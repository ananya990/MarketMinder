package com.ananya302.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ananya302.model.Customer;

@Repository
public class CustomerImpl implements CustomerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Customer customer) {
        String sql = "INSERT INTO SupermarketInventorydb.customer(cid, cname, caddress, cphoneNumber, purchaseID) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, 
                customer.getCid(),
                customer.getCname(),
                customer.getCaddress(),
                customer.getCphoneNumber(),
                customer.getPurchaseID());
    }

    @Override
    public int update(Customer customer, int cid) {
        String sql = "UPDATE SupermarketInventorydb.customer SET cname=?, caddress=?, cphoneNumber=?, purchaseID=? WHERE cid=?";
        return jdbcTemplate.update(sql,
                customer.getCname(),
                customer.getCaddress(),
                customer.getCphoneNumber(),
                customer.getPurchaseID(),
                cid);
    }

    @Override
    public int delete(int cid) {
        String sql = "DELETE FROM SupermarketInventorydb.customer WHERE cid=?";
        return jdbcTemplate.update(sql, cid);
    }

    @Override
    public List<Customer> getAll() {
        String sql = "SELECT * FROM SupermarketInventorydb.customer";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }

    @Override
    public Customer getById(int cid) {
        String sql = "SELECT * FROM SupermarketInventorydb.customer WHERE cid=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Customer.class), cid);
    }
}
