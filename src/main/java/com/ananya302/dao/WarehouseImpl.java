package com.ananya302.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ananya302.model.Warehouse;

@Repository
public class WarehouseImpl implements WarehouseDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int add(Warehouse product) {
        String sql = "INSERT INTO SupermarketInventorydb.warehouse(ptype, quantity, sid) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, 
                product.getPtype(),
                product.getQuantity(),
                product.getSid());
    }

    @Override
    public int update(Warehouse product, String ptype) {
        String sql = "UPDATE SupermarketInventorydb.warehouse SET quantity=?, sid=? WHERE ptype=?";
        return jdbcTemplate.update(sql, 
                product.getQuantity(),
                product.getSid(),
                ptype);
    }

    @Override
    public int delete(String ptype) {
        String sql = "DELETE FROM SupermarketInventorydb.warehouse WHERE ptype=?";
        return jdbcTemplate.update(sql, ptype);
    }

    @Override
    public List<Warehouse> getAll() {
        return jdbcTemplate.query("SELECT * FROM SupermarketInventorydb.warehouse", new BeanPropertyRowMapper<Warehouse>(Warehouse.class));
    }

    @Override
    public Warehouse getById(String ptype) {
        return jdbcTemplate.queryForObject("SELECT * FROM SupermarketInventorydb.warehouse WHERE ptype = ?", new BeanPropertyRowMapper<>(Warehouse.class), ptype);
    }
    
    @Override
    public List<Warehouse> sortByQuantity() {
        String sql = "SELECT * FROM SupermarketInventorydb.warehouse ORDER BY quantity";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Warehouse.class));
    }
}
