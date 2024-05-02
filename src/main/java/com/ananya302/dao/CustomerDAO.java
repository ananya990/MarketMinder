package com.ananya302.dao;

import java.util.List;

import com.ananya302.model.Customer;

public interface CustomerDAO {
    
	int add(Customer customer);
    
	int update(Customer customer, int id);
    
	int delete(int id);
    
	List<Customer> getAll();
    
	Customer getById(int id);
}
