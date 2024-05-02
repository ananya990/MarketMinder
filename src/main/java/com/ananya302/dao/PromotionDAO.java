package com.ananya302.dao;

import java.util.List;
import com.ananya302.model.Promotion;

public interface PromotionDAO 
{
	int add(Promotion promotion);
    
	int update(Promotion promotion, String promoCode);
    
	int delete(String promoCode);
    
	List<Promotion> getAll();
    
	Promotion getById(String promoCode);
}
