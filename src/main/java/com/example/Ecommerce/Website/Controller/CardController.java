package com.example.Ecommerce.Website.Controller;

import com.example.Ecommerce.Website.DTO.RequestDto.CardRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.CardResponseDto;
import com.example.Ecommerce.Website.Enum.CardType;
import com.example.Ecommerce.Website.ExceptionHandling.InvalidCustomerException;
import com.example.Ecommerce.Website.Service.Interface.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/add")
    public ResponseEntity addCard(@RequestBody CardRequestDto cardRequestDto){
        try{
            CardResponseDto cardResponseDto = cardService.addCard(cardRequestDto);
            return new ResponseEntity(cardResponseDto, HttpStatus.CREATED);
        } catch (InvalidCustomerException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("get/{cardType}")
    public ResponseEntity getCardsByCardType(@PathVariable("cardType") CardType cardType){

        List<CardResponseDto> cardResponseDtoList=cardService.getCardsByCardType(cardType);
        return new ResponseEntity(cardResponseDtoList,HttpStatus.OK);
    }

    // get all VISA cards

    // get all MASTERCARD cards whose expert is greater than 1 Jan 2025

    // Return the CardType which has maximum number of that card

}