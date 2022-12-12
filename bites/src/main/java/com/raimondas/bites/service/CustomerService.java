package com.raimondas.bites.service;


import com.raimondas.bites.entity.Customer;
import com.raimondas.bites.payload.request.CustomerRequest;
import com.raimondas.bites.payload.request.CustomerUpdateRequest;
import com.raimondas.bites.payload.response.CustomerPageResponse;
import com.raimondas.bites.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerPageResponse> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);

        List<CustomerPageResponse> customerPageResponseList = customers.stream().
                map(CustomerPageResponse::fromCustomer).
                collect(Collectors.toList());
        return customerPageResponseList;
    }

    public CustomerPageResponse getCustomer(long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        CustomerPageResponse customerPageResponse = null;
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customerPageResponse = CustomerPageResponse.fromCustomer(customer);
        }
        return customerPageResponse;
    }


    @Transactional
    public void addCustomer(CustomerRequest customerRequest) {
        Customer customer = customerRequest.asCustomer();
        customerRepository.save(customer);
    }

    @Transactional
    public void updateCustomer(CustomerUpdateRequest customerUpdateRequest) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerUpdateRequest.getId());
        if(optionalCustomer.isPresent()) {
            customerRepository.updateCustomer(
                    customerUpdateRequest.getName(),
                    customerUpdateRequest.getSurname(),
                    customerUpdateRequest.getCompanyName(),
                    customerUpdateRequest.getCompanyCode(),
                    customerUpdateRequest.getPersonalCode(),
                    customerUpdateRequest.getAddress(),
                    customerUpdateRequest.getId()
            );
        }
    }

    public void deleteById(long id) {
        customerRepository.deleteById(id);
    }

    public Optional<Customer> findById (long id) {
        return customerRepository.findById(id);
    }
}
