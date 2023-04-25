package com.example.Ecommerce.Website.Service.Impl;

import com.example.Ecommerce.Website.DTO.RequestDto.SellerRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.SellerResponseDto;
import com.example.Ecommerce.Website.Entity.Seller;
import com.example.Ecommerce.Website.ExceptionHandling.EmailAlreadyPresentException;
import com.example.Ecommerce.Website.Repository.SellerRepository;
import com.example.Ecommerce.Website.Transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;

public class SellerServiceImpl {
    @Autowired
    SellerRepository sellerRepository;

    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) throws EmailAlreadyPresentException {



        if (sellerRepository.findByEmail(sellerRequestDto.getEmailId()) != null)
            throw new EmailAlreadyPresentException("Email Id already registered");

        Seller seller = SellerTransformer.SellerRequestDtoToSeller(sellerRequestDto);
        Seller savedSeller = sellerRepository.save(seller);

        // prepare response Dto
        SellerResponseDto sellerResponseDto = SellerTransformer.SellerToSellerResponseDto(savedSeller);
        return sellerResponseDto;

    }
}
