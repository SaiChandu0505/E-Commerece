package com.example.Ecommerce.Website.Transformer;

import com.example.Ecommerce.Website.DTO.RequestDto.CustomerRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.CustomerResponseDto;
import com.example.Ecommerce.Website.Entity.Customer;

public class CustomerTransformer {
    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){


        return Customer.builder()
                .age(customerRequestDto.getAge())
                .name(customerRequestDto.getName())
                .address(customerRequestDto.getAddress())
                .emailId(customerRequestDto.getEmailId())
                .mobNo(customerRequestDto.getMobNo())
                .build();
    }

    public static CustomerResponseDto CustomerToCustomerResponseDto(Customer customer){

        return CustomerResponseDto.builder()
                .name(customer.getName())
                .message("Welcome" + customer.getName()+ " to Amazon !!!")
                .build();
    }
}
