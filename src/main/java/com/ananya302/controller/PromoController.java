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
import com.ananya302.dao.PromotionDAO; 
import com.ananya302.model.Promotion;

@RestController
@RequestMapping("/api")
public class PromoController {
    @Autowired
    private PromotionDAO promotionDAO;

    @GetMapping("/promotions")
    public List<Promotion> getAllPromotions() {
        return promotionDAO.getAll();
    }

    @GetMapping("/promotions/{promoCode}")
    public Promotion getPromotionByCode(@PathVariable("promoCode") String promoCode) {
        return promotionDAO.getById(promoCode);
    }

    @PostMapping("/promotions")
    public String addPromotion(@RequestBody Promotion promotion) {
        int result = promotionDAO.add(promotion);
        return result == 1 ? "Promotion added successfully" : "Failed to add promotion";
    }

    @PutMapping("/promotions/{promoCode}")
    public String updatePromotion(@RequestBody Promotion promotion, @PathVariable String promoCode) {
        int result = promotionDAO.update(promotion, promoCode);
        return result == 1 ? "Promotion updated successfully" : "Failed to update promotion";
    }

    @DeleteMapping("/promotions/{promoCode}")
    public String deletePromotion(@PathVariable String promoCode) {
        int result = promotionDAO.delete(promoCode);
        return result == 1 ? "Promotion deleted successfully" : "Failed to delete promotion";
    }
}
