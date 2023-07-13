package com.rentalform.rentalform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentalform.rentalform.model.RentalForm;



public interface RentalFormRepo extends JpaRepository<RentalForm,Long> {
    
    
}
