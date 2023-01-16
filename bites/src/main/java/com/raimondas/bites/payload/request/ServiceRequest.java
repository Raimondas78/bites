package com.raimondas.bites.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.raimondas.bites.entity.Service;
import com.raimondas.bites.entity.Type;

import javax.validation.constraints.NotBlank;

public class ServiceRequest {

    long id;

    @NotBlank(message = "Ordered service name must be present")
    private final String name;

    @NotBlank(message = "Ordered service type must be present")
    private final String type;

    private final String description;

    public ServiceRequest(@JsonProperty("id") long id, @JsonProperty("name") String name,
                          @JsonProperty("type") String type,
                          @JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Service asService(ServiceRequest serviceRequest) {
        Service service = new Service(serviceRequest.getName(), Type.valueOf(serviceRequest.getType()), serviceRequest.getDescription());
        return  service;
    }
}
