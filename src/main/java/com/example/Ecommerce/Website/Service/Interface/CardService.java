package com.example.Ecommerce.Website.Service.Interface;

import com.example.Ecommerce.Website.DTO.RequestDto.CardRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.CardResponseDto;
import com.example.Ecommerce.Website.Enum.CardType;
import com.example.Ecommerce.Website.ExceptionHandling.InvalidCustomerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CardService {

    public CardResponseDto addCard(@RequestBody CardRequestDto cardRequestDto) throws InvalidCustomerException;
    public List<CardResponseDto> getCardsByCardType(CardType cardType);
}
