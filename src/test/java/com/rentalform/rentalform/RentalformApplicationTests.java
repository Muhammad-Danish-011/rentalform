package com.rentalform.rentalform;

import com.rentalform.rentalform.controller.RentalFormController;
import com.rentalform.rentalform.model.RentalForm;
import com.rentalform.rentalform.repository.RentalFormRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RentalFormControllerTest {

    private RentalFormController rentalFormController;

    @Mock
    private RentalFormRepo rentalFormRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        rentalFormController = new RentalFormController(rentalFormRepository);
    }

    @Test
    void addRentalForm_ValidRentalForm_ReturnsSavedRentalForm() {
        RentalForm rentalForm = new RentalForm(); 

        when(rentalFormRepository.save(rentalForm)).thenReturn(rentalForm);

        RentalForm savedRentalForm = rentalFormController.addRentalForm(rentalForm);

        assertEquals(rentalForm, savedRentalForm);
        verify(rentalFormRepository, times(1)).save(rentalForm);
    }

    @Test
    void getAllRentalForms_NoRentalForms_ReturnsEmptyList() {
        List<RentalForm> rentalForms = new ArrayList<>(); 

        when(rentalFormRepository.findAll()).thenReturn(rentalForms);

        ResponseEntity<List<RentalForm>> response = rentalFormController.getAllRentalForms();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(rentalForms, response.getBody());
        verify(rentalFormRepository, times(1)).findAll();
    }

    @Test
    void deleteAllRentalForms_CallsDeleteAll_ReturnsSuccessMessage() {
        ResponseEntity<String> expectedResponse = ResponseEntity.ok("All RentalForms deleted successfully.");

        ResponseEntity<String> response = rentalFormController.deleteAllRentalForms();

        assertEquals(expectedResponse, response);
        verify(rentalFormRepository, times(1)).deleteAll();
    }
}
