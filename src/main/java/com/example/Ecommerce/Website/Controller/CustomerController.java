package com.example.Ecommerce.Website.Controller;

import com.example.Ecommerce.Website.DTO.RequestDto.CustomerRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.CustomerResponseDto;
import com.example.Ecommerce.Website.ExceptionHandling.MobileNoAlreadyPresentException;
import com.example.Ecommerce.Website.Service.Interface.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public CustomerResponseDto addCustomer(@RequestBody CustomerRequestDto customerRequestDto) throws MobileNoAlreadyPresentException {

        return customerService.addCustomer(customerRequestDto);
    }

    // view all customers

    // get a customer by email/mob

    // get all customers whose age is greater than 25

    // get all customers who use VISA card

    // update a customer info by email

    // delete a customer by email/mob

}