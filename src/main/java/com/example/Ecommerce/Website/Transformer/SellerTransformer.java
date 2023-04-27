package com.example.Ecommerce.Website.Transformer;

import com.example.Ecommerce.Website.DTO.RequestDto.SellerRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.SellerResponseDto;
import com.example.Ecommerce.Website.Entity.Seller;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SellerTransformer {

    public static SellerResponseDto SellerToSellerResponseDto(Seller seller){
        return SellerResponseDto.builder()
                .age(seller.getAge())
                .name(seller.getName())
                .build();
    }
    public static Seller SellerRequestDtoTOSeller(SellerRequestDto sellerRequestDto){
        return Seller.builder()
                .age(sellerRequestDto.getAge())
                .mobNo(sellerRequestDto.getMobNo())
                .emailId(sellerRequestDto.getEmailId())
                .name(sellerRequestDto.getName())
                .build();
    }
}
