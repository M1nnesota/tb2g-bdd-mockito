package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.BindingResult;
import guru.springframework.sfgpetclinic.fauxspring.MockBindingResult;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    private OwnerService service;

    @InjectMocks
    private OwnerController controller;

    @Test
    void testProcessCreationFormWithErrors() {
        BindingResult bindingResult = new MockBindingResult(true);
        Owner owner = new Owner(1L, "test", "test");

        String returnedView = controller.processCreationForm(owner, bindingResult);

        assertEquals("owners/createOrUpdateOwnerForm", returnedView);
    }

    @Test
    void testProcessCreationFormWithoutErrors() {
        BindingResult result = new MockBindingResult(false);
        Owner owner = new Owner(5L, "test", "test");

        when(service.save(any())).thenReturn(owner);

        String returnedView = controller.processCreationForm(owner, result);

        assertEquals("redirect:/owners/5", returnedView);
        verify(service).save(any());
    }
}