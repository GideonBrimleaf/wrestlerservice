package com.codeclan.example.wrestlerservice.controllers;

import com.codeclan.example.wrestlerservice.models.Injury;
import com.codeclan.example.wrestlerservice.models.Wrestler;
import com.codeclan.example.wrestlerservice.repositories.WrestlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WrestlerController {

    @Autowired
    WrestlerRepository wrestlerRepository;

    @GetMapping("/wrestlers")
    public ResponseEntity<List<Wrestler>> getAllWrestlers(@RequestParam(name="firstname", required = false) String firstName, @RequestParam(name="promotion-name", required = false) String promotion) {
        if (firstName != null) {
            return new ResponseEntity<>(wrestlerRepository.findByFirstName(firstName), HttpStatus.OK);
        }
        if (promotion != null) {
            return new ResponseEntity<>(wrestlerRepository.findByPromotionName(promotion), HttpStatus.OK);
        }
        return new ResponseEntity<>(wrestlerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/wrestlers/{id}")
    public ResponseEntity<Optional<Wrestler>> getWrestler(@PathVariable Long id) {
        return new ResponseEntity<>(wrestlerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/wrestlers")
    public ResponseEntity<Wrestler> createWrestler(@RequestBody Wrestler newWrestler){
        wrestlerRepository.save(newWrestler);
        return new ResponseEntity<>(newWrestler, HttpStatus.CREATED);
    }

    @DeleteMapping("/wrestlers/{id}")
    public ResponseEntity<Long> deleteWrestler(@PathVariable Long id) {
        wrestlerRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/wrestlers/{id}")
    public ResponseEntity<Wrestler> updateWrestler(@PathVariable Long id, @RequestBody Wrestler updatedWrestlerDetails) {
        Wrestler wrestlerToUpdate = wrestlerRepository.findById(id).get();
        wrestlerToUpdate.setFirstName(updatedWrestlerDetails.getFirstName());
        wrestlerToUpdate.setLastName(updatedWrestlerDetails.getLastName());
        wrestlerToUpdate.setAge(updatedWrestlerDetails.getAge());
        wrestlerToUpdate.setInjured(updatedWrestlerDetails.getInjured());
        wrestlerToUpdate.setPromotion(updatedWrestlerDetails.getPromotion());
        wrestlerRepository.save(wrestlerToUpdate);
        return new ResponseEntity<>(wrestlerToUpdate, HttpStatus.OK);
    }


    @PatchMapping("/wrestlers/{id}")
    public ResponseEntity<Wrestler> updateWrestlingInjury(@PathVariable Long id, @RequestBody Injury injury) {
        Wrestler wrestlerToUpdate = wrestlerRepository.findById(id).get();
        wrestlerToUpdate.setInjured(injury.getStatus());
        wrestlerRepository.save(wrestlerToUpdate);
        return new ResponseEntity<>(wrestlerToUpdate, HttpStatus.OK);
    }
}
