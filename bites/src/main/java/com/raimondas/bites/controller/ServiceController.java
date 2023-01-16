package com.raimondas.bites.controller;

import com.raimondas.bites.entity.Service;
import com.raimondas.bites.payload.request.ServiceRequest;
import com.raimondas.bites.repository.ServiceRepository;
import com.raimondas.bites.service.RegularService;
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
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private RegularService regularService;

    @Operation(summary = "Get all services")
    @ApiResponses(value = {@ApiResponse(content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class)))})})
    @GetMapping("/service")
    public ResponseEntity<List<Service>> getAllServices() {
        return ResponseEntity.ok(regularService.getServices());
    }

    @Operation(summary = "Get service by id")
    @ApiResponses(value = {@ApiResponse(content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class)))})})
    @GetMapping("/service/{id}")
    public ResponseEntity<Service> getService(@PathVariable("id") @Min(1) long id) {
       Service service = regularService.findById(id);
        return ResponseEntity.ok(service);
    }

    @Operation(summary = "Delete service by id")
    @ApiResponses(value = {@ApiResponse(content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class)))})})
    @DeleteMapping("/service/{id}")
    public ResponseEntity<Service> deleteService(@PathVariable("id") @Min(1) long id) {
        regularService.deleteServiceById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Create service")
    @ApiResponses(value = {@ApiResponse(content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class)))})})
    @PostMapping("/service")
    public ResponseEntity<Service> createService(@RequestBody @Valid ServiceRequest serviceRequest) throws URISyntaxException {
        Service service = regularService.createService(serviceRequest);
        return ResponseEntity.created(new URI("/service/" + service.getId())).body(service);
    }

    @Operation(summary = "Update service by id")
    @ApiResponses(value = {@ApiResponse(content = {@Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = ResponseEntity.class)))})})
    @PutMapping("/service")
    public ResponseEntity<Service> updateService(@RequestBody @Valid ServiceRequest serviceRequest) {
        regularService.updateService(serviceRequest);
        return ResponseEntity.ok().build();
    }
}
