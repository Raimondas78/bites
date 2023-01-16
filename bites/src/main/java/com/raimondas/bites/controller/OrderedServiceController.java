package com.raimondas.bites.controller;

import com.raimondas.bites.entity.OrderedService;
import com.raimondas.bites.payload.request.OrderedServiceCreateRequest;
import com.raimondas.bites.payload.request.OrderedServiceUpdateRequest;
import com.raimondas.bites.payload.response.OrderedServicePageResponse;
import com.raimondas.bites.repository.OrderedServiceRepository;
import com.raimondas.bites.repository.ServiceRepository;
import com.raimondas.bites.service.CustomerService;
import com.raimondas.bites.service.OrderedServiceService;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class OrderedServiceController {

    @Autowired
    private OrderedServiceService orderedServiceService;

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private OrderedServiceRepository orderedServiceRepository;


    @Operation(summary = "Get all orderedServices")
    @ApiResponses(value = {@ApiResponse(content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class)))})})
    @GetMapping("/orderedService")
    public ResponseEntity<List<OrderedServicePageResponse>> getAllServices() {
        List<OrderedServicePageResponse> orderedServicePageResponses = orderedServiceService.getAllOrderedServices();
        return ResponseEntity.ok(orderedServicePageResponses);
    }

    @Operation(summary = "Get all orderedServices for customer")
    @ApiResponses(value = {@ApiResponse(content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class)))})})
    @GetMapping("/orderedService/customer/{id}")
    public ResponseEntity<List<OrderedServicePageResponse>> getServicesOfCustomer(@PathVariable("id") long id) {
        List<OrderedService> services = orderedServiceService.findByCustomerId(id);

        List<OrderedServicePageResponse> pageResponses = services.stream().
                map(OrderedServicePageResponse::fromOrderedService).collect(Collectors.toList());
        return ResponseEntity.ok(pageResponses);
    }

    @Operation(summary = "Get orderedService by id")
    @ApiResponses(value = {@ApiResponse(content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class)))})})
    @GetMapping("/orderedService/{id}")
    public ResponseEntity<OrderedServicePageResponse> getServiceById(@PathVariable("id") long id) {
        OrderedServicePageResponse orderedServicePageResponse = orderedServiceService.findById(id);
        return ResponseEntity.ok(orderedServicePageResponse);
    }

    @Operation(summary = "Get all orderedServices with service id")
    @ApiResponses(value = {@ApiResponse(content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class)))})})
    @GetMapping("/orderedService/service/{id}")
    public ResponseEntity<List<OrderedServicePageResponse>> getOrderedServicesByServiceId(@PathVariable("id") long id) {
        List<OrderedServicePageResponse> orderedServices = orderedServiceService.findOrderedServicesByServiceId(id);
        return ResponseEntity.ok(orderedServices);
    }


    @Operation(summary = "Delete orderedService by id")
    @ApiResponses(value = {@ApiResponse(content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class)))})})
    @DeleteMapping("/orderedService/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable("id") @Min(1) long id) {
        orderedServiceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Create ordered service")
    @ApiResponses(value = {@ApiResponse(content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class)))})})
    @PostMapping("/orderedService")
    public ResponseEntity<OrderedServicePageResponse> createOrderedService(@RequestBody OrderedServiceCreateRequest orderedServiceCreateRequest) throws URISyntaxException {
        OrderedServicePageResponse orderedServicePageResponse = orderedServiceService.createOrderedService(orderedServiceCreateRequest);
        return ResponseEntity.created(new URI("/orderedService/" + orderedServicePageResponse.getId()))
                .body(orderedServicePageResponse);
    }

    @Operation(summary = "Update orderedService")
    @ApiResponses(value = {@ApiResponse(content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class)))})})
    @PutMapping("/orderedService")
    public ResponseEntity<Void> updateOrderedService(@RequestBody @Valid OrderedServiceUpdateRequest orderedServiceUpdateRequest) {
        orderedServiceService.updateOrderedService(orderedServiceUpdateRequest);
        return ResponseEntity.noContent().build();
    }

}
