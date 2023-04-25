package com.example.Ecommerce.Website.Service.Interface;

import com.example.Ecommerce.Website.DTO.RequestDto.CustomerRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.CustomerResponseDto;
import com.example.Ecommerce.Website.ExceptionHandling.MobileNoAlreadyPresentException;
import org.springframework.web.bind.annotation.RequestBody;

public interface CustomerService {

    public CustomerResponseDto addCustomer(@RequestBody CustomerRequestDto customerRequestDto) throws MobileNoAlreadyPresentException;
}
