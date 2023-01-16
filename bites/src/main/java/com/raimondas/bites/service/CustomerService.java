package com.raimondas.bites.service;


import com.raimondas.bites.entity.Customer;
import com.raimondas.bites.entity.CustomerCode;
import com.raimondas.bites.exception.EntityNotFoundException;
import com.raimondas.bites.payload.request.CustomerRequest;
import com.raimondas.bites.payload.request.CustomerUpdateRequest;
import com.raimondas.bites.payload.response.CustomerPageResponse;
import com.raimondas.bites.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        } else {
            throw new EntityNotFoundException("Customer with " + id + " does not exist");
        }
        return customerPageResponse;
    }


    @Transactional
    public CustomerPageResponse addCustomer(CustomerRequest customerRequest) {
        CustomerCode customerCode = customerRequest.getCustomerCode();
        Customer customer = customerRequest.asCustomer(customerCode);
        Customer newCustomer = customerRepository.save(customer);
        return CustomerPageResponse.fromCustomer(newCustomer);
    }

    @Transactional
    public void updateCustomer(CustomerUpdateRequest customerUpdateRequest) {

        Optional<Customer> customerOptional = customerRepository.findById(customerUpdateRequest.getId());
        if (customerOptional.isPresent()) {

                Customer customer = customerOptional.get();
                CustomerCode customerCode = customer.getCustomerCode();

                if (Objects.equals(customerCode.getId(), customerUpdateRequest.getCustomerCode().getId())) {

                    Customer newCustomer = new Customer(
                            customer.getId(),
                            customerUpdateRequest.getName(),
                            customerUpdateRequest.getSurname(),
                            customerUpdateRequest.getCustomerCode(),
                            customerUpdateRequest.getAddress());
                    customerRepository.save(newCustomer);
                } else {
                    throw new IllegalArgumentException("Customer code id does not match existing id database");
                }

        } else {
            throw new EntityNotFoundException("Customer with id = {} " + customerUpdateRequest.getId() +
                    "does not exist in the system.");
        }

    }

    public void deleteById(long id) {
        Optional<Customer> optionalCustomer = findById(id);
        if (optionalCustomer.isPresent()) {
            customerRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Customer with id = " + id + " does not exist");
        }
    }

    public Optional<Customer> findById(long id) {
        return customerRepository.findById(id);
    }

}
