package com.rentalform.rentalform.model;



import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name="Form")
public class RentalForm {

@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String address ;
    private String email;
    private String phone;
   private LocalDateTime  Pick;
    private LocalDateTime  drop;
    private String driverlicense ;
  
   

}
