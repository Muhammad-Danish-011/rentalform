package com.rentalform.rentalform.controller;

 import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

import com.rentalform.rentalform.model.RentalForm;
import com.rentalform.rentalform.repository.RentalFormRepo;

import java.util.List;
    
    @CrossOrigin("*")
    @RestController
    @RequestMapping("/RentalForms")



public class RentalFormController {

    
        private final RentalFormRepo RentalFormRepository;
    
        @Autowired
        public RentalFormController(RentalFormRepo RentalFormRepository) {
            this.RentalFormRepository = RentalFormRepository;
        }
    
        @PostMapping("/add")
        public RentalForm addRentalForm(@RequestBody RentalForm RentalForm) {
            return RentalFormRepository.save(RentalForm);
        }
    
        @GetMapping("/all")
        public ResponseEntity<List<RentalForm>> getAllRentalForms() {
            List<RentalForm> RentalForms = RentalFormRepository.findAll();
            return ResponseEntity.ok(RentalForms);
        }
        @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAllRentalForms() {
        RentalFormRepository.deleteAll();
        return ResponseEntity.ok("All RentalForms deleted successfully.");
    }
  
    




}
