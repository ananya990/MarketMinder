package com.ananya302.dao;

import java.util.List;
import com.ananya302.model.Supplier;

public interface SupplierDAO 
{
	int add(Supplier supplier);
    
	int update(Supplier supplier, int sid);
    
	int delete(int sid);
    
	List<Supplier> getAll();
    
	Supplier getById(int sid);
}
