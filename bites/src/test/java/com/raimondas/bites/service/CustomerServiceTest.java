package com.raimondas.bites.service;

import com.raimondas.bites.entity.Customer;
import com.raimondas.bites.entity.CustomerCode;
import com.raimondas.bites.payload.request.CustomerRequest;
import com.raimondas.bites.payload.response.CustomerPageResponse;
import com.raimondas.bites.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;


    @Test
    void addCustomerWithDifferentNames() {
        CustomerCode customerCode = new CustomerCode(1L, "11111111111",
                "ccode", "cname");
        CustomerRequest customerRequest = new CustomerRequest("N", "S", "A", customerCode);
        when(customerRepository.save(any(Customer.class))).thenReturn(new Customer("F", "S", "A", customerCode));

        CustomerPageResponse created = customerService.addCustomer(customerRequest);
        assertThat(created.getName()).isNotSameAs(customerRequest.getName());
    }
}