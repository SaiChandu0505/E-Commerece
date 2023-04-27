package com.example.Ecommerce.Website.Transformer;

import com.example.Ecommerce.Website.DTO.ResponseDto.CartResponseDto;
import com.example.Ecommerce.Website.Entity.Cart;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CartTransformer {
    public static CartResponseDto CartToCartResponseDto(Cart cart){
        return CartResponseDto.builder()
                .customerName(cart.getCustomer().getName())
                .numberOfItem(cart.getNumberOfItems())
                .totalCost(cart.getCartTotal())
                .build();
    }
}