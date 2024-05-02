package com.ananya302.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ananya302.model.Product;

@Repository
public class ProductImpl implements ProductDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int add(Product product) {
        String sql = "INSERT INTO SupermarketInventorydb.product(pid, pname, ptype, prize) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, 
                product.getPid(),
                product.getPname(), 
                product.getPtype(), 
                product.getPrize());
    }

    @Override
    public int update(Product product, String pid) {
        String sql = "UPDATE SupermarketInventorydb.product SET pname=?, ptype=?, prize=? WHERE pid=?";
        return jdbcTemplate.update(sql, 
                product.getPname(), 
                product.getPtype(), 
                product.getPrize(), 
                pid);
    }

    @Override
    public int delete(String pid) {
        String sql = "DELETE FROM SupermarketInventorydb.product WHERE pid=?";
        return jdbcTemplate.update(sql, pid);
    }

    @Override
    public List<Product> getAll() {
        return jdbcTemplate.query("SELECT * FROM SupermarketInventorydb.product", new BeanPropertyRowMapper<Product>(Product.class));
    }

    @Override
    public Product getById(String pid) {
        return jdbcTemplate.queryForObject("SELECT * FROM SupermarketInventorydb.product WHERE pid = ?", new BeanPropertyRowMapper<>(Product.class), pid);
    }
    
    @Override
    public List<Product> getByCategory(String category) {
        String sql = "SELECT * FROM SupermarketInventorydb.product WHERE ptype = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class), category);
    }

    @Override
    public List<Product> sortByPrize() {
        String sql = "SELECT * FROM SupermarketInventorydb.product ORDER BY prize";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }
}
