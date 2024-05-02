package com.ananya302.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ananya302.model.Promotion;

@Repository
public class PromotionImpl implements PromotionDAO 
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int add(Promotion promotion) {
        String sql = "INSERT INTO SupermarketInventorydb.promotion(promoCode, promoName, startDate, endDate, discountPercentage) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, 
                promotion.getPromoCode(),
                promotion.getPromoName(), 
                promotion.getStartDate(), 
                promotion.getEndDate(),
                promotion.getDiscountPercentage());
    }

    @Override
    public int update(Promotion promotion, String promoCode) {
        String sql = "UPDATE SupermarketInventorydb.promotion SET promoName=?, startDate=?, endDate=?, discountPercentage=? WHERE promoCode=?";
        return jdbcTemplate.update(sql, 
                promotion.getPromoName(), 
                promotion.getStartDate(), 
                promotion.getEndDate(), 
                promotion.getDiscountPercentage(),
                promoCode);
    }

    @Override
    public int delete(String promoCode) {
        String sql = "DELETE FROM SupermarketInventorydb.promotion WHERE promoCode=?";
        return jdbcTemplate.update(sql, promoCode);
    }

    @Override
    public List<Promotion> getAll() {
        return jdbcTemplate.query("SELECT * FROM SupermarketInventorydb.promotion", new BeanPropertyRowMapper<Promotion>(Promotion.class));
    }

    @Override
    public Promotion getById(String promoCode) {
        return jdbcTemplate.queryForObject("SELECT * FROM SupermarketInventorydb.promotion WHERE promoCode = ?", new BeanPropertyRowMapper<>(Promotion.class), promoCode);
    }
}
