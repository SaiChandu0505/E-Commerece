package com.example.Ecommerce.Website.Service.Impl;

import com.example.Ecommerce.Website.DTO.RequestDto.CardRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.CardResponseDto;
import com.example.Ecommerce.Website.Entity.Card;
import com.example.Ecommerce.Website.Entity.Customer;
import com.example.Ecommerce.Website.Enum.CardType;
import com.example.Ecommerce.Website.ExceptionHandling.CardAlreadyExistException;
import com.example.Ecommerce.Website.ExceptionHandling.InvalidCustomerException;
import com.example.Ecommerce.Website.Repository.CardRepository;
import com.example.Ecommerce.Website.Repository.CustomerRepository;
import com.example.Ecommerce.Website.Service.Interface.CardService;
import com.example.Ecommerce.Website.Transformer.CardTransformer;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws InvalidCustomerException{

        //check for valid customer
        Customer customer=customerRepository.findByEmailId(cardRequestDto.getCustomerEmailId());

        //throwing error in case of invalid customer
        if(customer == null){
            throw new InvalidCustomerException("Sorry ! Customer doesn't exists ");
        }

        //setting card attriibutes
        Card card= CardTransformer.CardRequestDtoTOCard(cardRequestDto);
        card.setCustomer(customer);

//        //check if card already exist in the customer cardList
//        if(customer.getCards().contains(card)){
//            throw new CardAlreadyExistException("Card already exists in the Customer Card List");
//        }

        //adding card to customer card list
        customer.getCards().add(card);
        customerRepository.save(customer); //this will save both customer as well as card in cardRepository

        //returning cardResponseDto via Card Transformer
        return CardTransformer.CardToCardResponseDto(card);
    }

    @Override
    public List<CardResponseDto> getCardsByCardType(CardType cardType) {
        List<Card>cardList=cardRepository.findByCardType(cardType);
        List<CardResponseDto>cardResponseDtoList=new ArrayList<>();

        for(Card card:cardList){
            cardResponseDtoList.add(CardTransformer.CardToCardResponseDto(card));
        }
        return cardResponseDtoList;
    }


}