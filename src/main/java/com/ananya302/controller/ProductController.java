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
import com.ananya302.dao.ProductDAO; 
import com.ananya302.model.Product;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productDAO.getAll();
    }

    @GetMapping("/products/{pid}")
    public Product getProductById(@PathVariable("pid") String pid) {
        return productDAO.getById(pid);
    }

    @PostMapping("/products")
    public String addProduct(@RequestBody Product product) {
        int result = productDAO.add(product);
        return result == 1 ? "Product added successfully" : "Failed to add product";
    }

    @PutMapping("/products/{pid}")
    public String updateProduct(@RequestBody Product product, @PathVariable String pid) {
        int result = productDAO.update(product, pid);
        return result == 1 ? "Product updated successfully" : "Failed to update product";
    }

    @DeleteMapping("/products/{pid}")
    public String deleteProduct(@PathVariable String pid) {
        int result = productDAO.delete(pid);
        return result == 1 ? "Product deleted successfully" : "Failed to delete product";
    }
    
    // Filter products by category
    @GetMapping("/products/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") String category) {
        return productDAO.getByCategory(category);
    }

    // Sort products by prize
    @GetMapping("/products/sortByPrize")
    public List<Product> getProductsSortedByPrize() {
        return productDAO.sortByPrize();
    }
}
