package com.ananya302.dao;

import java.util.List;
import com.ananya302.model.Product;

public interface ProductDAO {
	
    int add(Product product);
    
    int update(Product product, String pid);
    
    int delete(String pid);
    
    List<Product> getAll();
    
    Product getById(String pid);
	
    List<Product> getByCategory(String category);
	
    List<Product> sortByPrize();
}
