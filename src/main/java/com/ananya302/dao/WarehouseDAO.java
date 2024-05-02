package com.ananya302.dao;

import java.util.List;
import com.ananya302.model.Warehouse;

public interface WarehouseDAO 
{
	int add(Warehouse product);
    
	int update(Warehouse product, String ptype);
    
	int delete(String ptype);
    
	List<Warehouse> getAll();
    
	Warehouse getById(String ptype);
	
	List<Warehouse> sortByQuantity();
}
