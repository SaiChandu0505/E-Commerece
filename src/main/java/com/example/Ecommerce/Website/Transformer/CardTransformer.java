package com.example.Ecommerce.Website.Transformer;

import com.example.Ecommerce.Website.DTO.RequestDto.CardRequestDto;
import com.example.Ecommerce.Website.Entity.Card;

public class CardTransformer {
    public static Card CardRequestDtoToCard(CardRequestDto cardRequestDto){

        return Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cardType(cardRequestDto.getCardType())
                .cvv(cardRequestDto.getCvv())
                .expiryDate(cardRequestDto.getExpiryDate())
                .build();
    }
}
