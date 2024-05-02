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
import com.ananya302.dao.SupplierDAO; 
import com.ananya302.model.Supplier;

@RestController
@RequestMapping("/api")
public class SupplierController {
    @Autowired
    private SupplierDAO sDAO;
    
    @GetMapping("/suppliers")
    public List<Supplier> getSuppliers() {
        return sDAO.getAll();
    }
    
    @GetMapping("/suppliers/{sid}")
    public Supplier getSupplierById(@PathVariable("sid") int sid) {
        return sDAO.getById(sid);
    }
    
    @PostMapping("/suppliers")
    public String addSupplier(@RequestBody Supplier supplier) {
        int result = sDAO.add(supplier);
        return result == 1 ? "Supplier added successfully" : "Failed to add supplier";
    }
    
    @PutMapping("/suppliers/{sid}")
    public String updateSupplier(@RequestBody Supplier supplier, @PathVariable int sid) {
        int result = sDAO.update(supplier, sid);
        return result == 1 ? "Supplier updated successfully" : "Failed to update supplier";
    }

    @DeleteMapping("/suppliers/{sid}")
    public String deleteSupplier(@PathVariable int sid) {
        int result = sDAO.delete(sid);
        return result == 1 ? "Supplier deleted successfully" : "Failed to delete supplier";
    }
}
