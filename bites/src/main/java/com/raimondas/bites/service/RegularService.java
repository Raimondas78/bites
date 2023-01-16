package com.raimondas.bites.service;

import com.raimondas.bites.entity.Service;
import com.raimondas.bites.entity.Type;
import com.raimondas.bites.exception.EntityNotFoundException;
import com.raimondas.bites.payload.request.ServiceRequest;
import com.raimondas.bites.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class RegularService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<Service> getServices() {
        List<Service> services = new ArrayList<>();
        serviceRepository.findAll().forEach(services::add);
        return services;
    }

    public void deleteServiceById(long id) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Service with id " +
                        id + " not found"));
        serviceRepository.deleteById(id);
    }

    @Transactional
    public Service createService(ServiceRequest serviceRequest) {
        Service service = serviceRequest.asService(serviceRequest);
        return serviceRepository.save(service);
    }

    public void updateService(ServiceRequest serviceRequest) {
        serviceRepository.findById(serviceRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("Service with id " +
                        serviceRequest.getId() + " not found"));
        Service newService = new Service(serviceRequest.getId(), serviceRequest.getName(),
                Type.valueOf(serviceRequest.getType()), serviceRequest.getDescription());
        serviceRepository.save(newService);
    }

    public Service findById(long id) {
        return  serviceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Service with id " +
                        id + " not found"));
    }
}
