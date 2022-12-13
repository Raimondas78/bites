package com.raimondas.bites.controller;

import com.raimondas.bites.payload.request.CustomerRequest;
import com.raimondas.bites.payload.request.CustomerUpdateRequest;
import com.raimondas.bites.payload.response.CustomerPageResponse;
import com.raimondas.bites.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {


    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/customer")
    private List<CustomerPageResponse> getAllCustomers() {

        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    private CustomerPageResponse getCustomer(@PathVariable("id") long id) {
        CustomerPageResponse customerPageResponse = customerService.getCustomer(id);
        if (customerPageResponse == null) {
            throw new RuntimeException("Customer with id = " + id + " does not exist");
        }
        return customerPageResponse;
    }

    @DeleteMapping("/customer/{id}")
    private void deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteById(id);
    }

    @PostMapping("/customer")
    private void createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        customerService.addCustomer(customerRequest);
    }

    @PutMapping("/customer")
    private void updateCustomer(@RequestBody @Valid CustomerUpdateRequest customerUpdateRequest) {
        customerService.updateCustomer(customerUpdateRequest);
    }

}
