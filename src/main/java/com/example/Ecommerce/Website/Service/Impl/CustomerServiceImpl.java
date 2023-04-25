package com.example.Ecommerce.Website.Service.Impl;

import com.example.Ecommerce.Website.DTO.RequestDto.CustomerRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.CustomerResponseDto;
import com.example.Ecommerce.Website.Entity.Cart;
import com.example.Ecommerce.Website.Entity.Customer;
import com.example.Ecommerce.Website.ExceptionHandling.MobileNoAlreadyPresentException;
import com.example.Ecommerce.Website.Repository.CustomerRepository;
import com.example.Ecommerce.Website.Service.Interface.CustomerService;
import com.example.Ecommerce.Website.Transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) throws MobileNoAlreadyPresentException {

        if (customerRepository.findByMobNo(customerRequestDto.getMobNo()) != null)
            throw new MobileNoAlreadyPresentException("Sorry! Customer already exists!");

        // request dto -> customer
        Customer customer = CustomerTransformer.CustomerRequestDtoToCustomer(customerRequestDto);
        Cart cart = Cart.builder()
                .cartTotal(0)
                .numberOfItems(0)
                .customer(customer)
                .build();
        customer.setCart(cart);

        Customer savedCustomer = customerRepository.save(customer);  // customer and cart

        // prepare response dto
        return CustomerTransformer.CustomerToCustomerResponseDto(savedCustomer);
    }
}
