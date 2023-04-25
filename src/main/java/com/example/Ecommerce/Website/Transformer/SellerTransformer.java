package com.example.Ecommerce.Website.Transformer;

import com.example.Ecommerce.Website.DTO.RequestDto.SellerRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.SellerResponseDto;
import com.example.Ecommerce.Website.Entity.Seller;

public class SellerTransformer {

    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){

        return Seller.builder()
                .name(sellerRequestDto.getName())
                .age(sellerRequestDto.getAge())
                .Email(sellerRequestDto.getEmail())
                .mobNo(sellerRequestDto.getMobNo())
                .panNo(sellerRequestDto.getPanNo())
                .build();
    }
    public static Seller SellerToSellerResponseDto(SellerResponseDto sellerResponseDto){

        return Seller.builder()
                .name(sellerResponseDto.getName())
                .age(sellerResponseDto.getAge())
                .build();
    }
}
