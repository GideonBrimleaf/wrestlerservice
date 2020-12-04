package com.codeclan.example.wrestlerservice.controllers;

import com.codeclan.example.wrestlerservice.models.Promotion;
import com.codeclan.example.wrestlerservice.repositories.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PromotionController {

    @Autowired
    PromotionRepository promotionRepository;

    @GetMapping("/promotions")
    public ResponseEntity<List<Promotion>> getAllPromotions(@RequestParam(name="wrestler-name", required = false) String wrestlerName) {
        if (wrestlerName != null) {
            return new ResponseEntity<>(promotionRepository.findByWrestlersFirstName(wrestlerName), HttpStatus.OK);
        }
        return new ResponseEntity<>(promotionRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/promotions/{id}")
    public ResponseEntity<Optional<Promotion>> getPromotion(@PathVariable Long id) {
        return new ResponseEntity<>(promotionRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/promotions")
    public ResponseEntity<Promotion> createPromotion(@RequestBody Promotion newPromotion){
        promotionRepository.save(newPromotion);
        return new ResponseEntity<>(newPromotion, HttpStatus.CREATED);
    }

    @DeleteMapping("/promotions/{id}")
    public ResponseEntity<Long> deletePromotion(@PathVariable Long id) {
        promotionRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/promotions/{id}")
    public ResponseEntity<Promotion> updatePromotion(@PathVariable Long id, @RequestBody Promotion updatedPromotionDetails) {
        Promotion promotionToUpdate = promotionRepository.findById(id).get();
        promotionToUpdate.setName(updatedPromotionDetails.getName());
        promotionToUpdate.setYearFounded(updatedPromotionDetails.getYearFounded());
        promotionRepository.save(promotionToUpdate);
        return new ResponseEntity<>(promotionToUpdate, HttpStatus.OK);
    }
}
