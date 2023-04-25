package com.example.Ecommerce.Website.Service.Impl;

import com.example.Ecommerce.Website.DTO.RequestDto.CardRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.CardResponseDto;
import com.example.Ecommerce.Website.Entity.Card;
import com.example.Ecommerce.Website.Entity.Customer;
import com.example.Ecommerce.Website.ExceptionHandling.InvalidCustomerException;
import com.example.Ecommerce.Website.Repository.CustomerRepository;
import com.example.Ecommerce.Website.Service.Interface.CardService;
import com.example.Ecommerce.Website.Transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;

public class CardServiceImpl implements CardService {

    @Autowired
    CustomerRepository customerRepository;

    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws InvalidCustomerException {

        Customer customer = customerRepository.findByMobNo(cardRequestDto.getMobNo());
        if (customer == null) {
            throw new InvalidCustomerException("Sorry! The customer doesn't exists");
        }

        Card card = CardTransformer.CardRequestDtoToCard(cardRequestDto);
        card.setCustomer(customer);

        customer.getCards().add(card);
        customerRepository.save(customer);

        // response dto
        return CardResponseDto.builder()
                .customerName(customer.getName())
                .cardNo(card.getCardNo())
                .build();
    }
}
