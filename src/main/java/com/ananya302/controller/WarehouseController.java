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
import com.ananya302.dao.WarehouseDAO;
import com.ananya302.model.Warehouse;

@RestController
@RequestMapping("/api")
public class WarehouseController 
{
    @Autowired
    private WarehouseDAO warehouseDAO;
    
    @GetMapping("/warehouse")
    public List<Warehouse> getAllProducts() {
        return warehouseDAO.getAll();
    }
    
    @GetMapping("/warehouse/{ptype}")
    public Warehouse getProductById(@PathVariable("ptype") String ptype) {
        return warehouseDAO.getById(ptype);
    }
    
    @PostMapping("/warehouse")
    public String addProduct(@RequestBody Warehouse product) {
        int result = warehouseDAO.add(product);
        return result == 1 ? "Product added successfully" : "Failed to add product";
    }
    
    @PutMapping("/warehouse/{ptype}")
    public String updateProduct(@RequestBody Warehouse product, @PathVariable String ptype) {
        int result = warehouseDAO.update(product, ptype);
        return result == 1 ? "Product updated successfully" : "Failed to update product";
    }

    @DeleteMapping("/warehouse/{ptype}")
    public String deleteProduct(@PathVariable String ptype) {
        int result = warehouseDAO.delete(ptype);
        return result == 1 ? "Product deleted successfully" : "Failed to delete product";
    }
    
    // Sort products by quantity
    @GetMapping("/warehouse/sortByQuantity")
    public List<Warehouse> getProductsSortedByPrize() {
        return warehouseDAO.sortByQuantity();
    }
}
