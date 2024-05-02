package com.ananya302.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ananya302.dao.CustomerDAO;
import com.ananya302.model.Customer;

@RestController
@RequestMapping("/api")
public class CusController 
{
    @Autowired
    private CustomerDAO cDAO;

    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return cDAO.getAll();
    }

    @GetMapping("/customer/{cid}")
    public Customer getCustomerById(@PathVariable int cid) {
        return cDAO.getById(cid);
    }

    @PostMapping("/customer")
    public String addCustomer(@RequestBody Customer customer) {
        int result = cDAO.add(customer);
        return result == 1 ? "Customer added successfully" : "Failed to add customer";
    }

    @PutMapping("/customer/{cid}")
    public String updateCustomer(@RequestBody Customer customer, @PathVariable int cid) {
        int result = cDAO.update(customer, cid);
        return result == 1 ? "Customer updated successfully" : "Failed to update customer";
    }

    @DeleteMapping("/customer/{cid}")
    public String deleteCustomer(@PathVariable int cid) {
        int result = cDAO.delete(cid);
        return result == 1 ? "Customer deleted successfully" : "Failed to delete customer";
    }
}
