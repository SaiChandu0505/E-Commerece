package com.example.Ecommerce.Website.Service.Interface;

import com.example.Ecommerce.Website.DTO.RequestDto.SellerRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.SellerResponseDto;
import com.example.Ecommerce.Website.ExceptionHandling.EmailIdAlreadyExistException;
import com.example.Ecommerce.Website.ExceptionHandling.InvalidSellerException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SellerService {


    SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) throws EmailIdAlreadyExistException;

    SellerResponseDto getSellerByEmailId(String emailId) throws InvalidSellerException;

    SellerResponseDto getSellerById(int id) throws InvalidSellerException;

    List<SellerResponseDto> getAllSellers();

    SellerResponseDto deleteSellerByEmailId(String emailId) throws InvalidSellerException;

    SellerResponseDto deleteSellerById(int id)throws InvalidSellerException;

    List<SellerResponseDto> getSellersOfAge(int age);

    SellerResponseDto updateSellerUsingEmailId(String emailId,SellerRequestDto sellerRequestDto) throws InvalidSellerException;
}
