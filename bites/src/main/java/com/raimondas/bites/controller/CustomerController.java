package com.raimondas.bites.controller;

import com.raimondas.bites.payload.request.CustomerRequest;
import com.raimondas.bites.payload.request.CustomerUpdateRequest;
import com.raimondas.bites.payload.response.CustomerPageResponse;
import com.raimondas.bites.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class CustomerController {


    @Autowired
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @Operation(summary = "Get all customers")
    @ApiResponses(value = {@ApiResponse(content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class)))})})
    @GetMapping("/customer")
    public ResponseEntity<List<CustomerPageResponse>> getAllCustomers() {
        List<CustomerPageResponse> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @Operation(summary = "Get customer by id")
    @ApiResponses(value = {@ApiResponse(content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class)))})})
    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerPageResponse> getCustomerById(@PathVariable("id") long id) {
        CustomerPageResponse customerPageResponse = customerService.getCustomer(id);
        return ResponseEntity.ok(customerPageResponse);
    }

    @Operation(summary = "Delete customer by id")
    @ApiResponses(value = {@ApiResponse(content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class)))})})
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") @Min(1) long id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Create customer")
    @ApiResponses(value = {@ApiResponse(content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class)))})})
    @PostMapping("/customer")
    public ResponseEntity<CustomerPageResponse> createCustomer(@RequestBody @Valid CustomerRequest customerRequest)
            throws URISyntaxException {
        CustomerPageResponse customerPageResponse = customerService.addCustomer(customerRequest);
        return ResponseEntity.created(new URI("/customer/" + customerPageResponse.getId())).body(customerPageResponse);
    }

    @Operation(summary = "Update customer")
    @ApiResponses(value = {@ApiResponse(content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class)))})})
    @PutMapping("/customer")
    public ResponseEntity<CustomerPageResponse> updateCustomer(@RequestBody @Valid CustomerUpdateRequest customerUpdateRequest) {
        customerService.updateCustomer(customerUpdateRequest);
        return ResponseEntity.noContent().build();
    }

}
