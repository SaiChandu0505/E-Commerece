package com.example.Ecommerce.Website.Service.Interface;

import com.example.Ecommerce.Website.DTO.RequestDto.SellerRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.SellerResponseDto;
import com.example.Ecommerce.Website.Entity.Seller;
import com.example.Ecommerce.Website.ExceptionHandling.EmailAlreadyPresentException;

public interface SellerService {

    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) throws EmailAlreadyPresentException;
}
