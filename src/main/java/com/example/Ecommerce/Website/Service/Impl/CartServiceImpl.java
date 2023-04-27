package com.example.Ecommerce.Website.Service.Impl;

import com.example.Ecommerce.Website.DTO.ResponseDto.CartResponseDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.ItemResponseDto;
import com.example.Ecommerce.Website.Entity.Cart;
import com.example.Ecommerce.Website.Entity.Customer;
import com.example.Ecommerce.Website.Entity.Item;
import com.example.Ecommerce.Website.Repository.CartRepository;
import com.example.Ecommerce.Website.Repository.CustomerRepository;
import com.example.Ecommerce.Website.Service.Interface.CartService;
import com.example.Ecommerce.Website.Transformer.CartTransformer;
import com.example.Ecommerce.Website.Transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CartRepository cartRepository;
    @Override
    public CartResponseDto addToCart(int customerId, Item item) {
        Customer customer=customerRepository.findById(customerId).get();
        Cart cart=customer.getCart();

        int newTotal=cart.getCartTotal()+item.getProduct().getPrice()* item.getRequiredQuantity();
        cart.setCartTotal(newTotal);
        //cart.getItems().add(item);

        int newNoOfItems=cart.getNumberOfItems()+item.getRequiredQuantity();
        cart.setNumberOfItems(newNoOfItems);

        Cart savedCart=cartRepository.save(cart);

        CartResponseDto cartResponseDto= CartTransformer.CartToCartResponseDto(savedCart);

        List<ItemResponseDto> itemResponseDtoList=new ArrayList<>();

        for(Item item1:cart.getItems()){
            ItemResponseDto itemResponseDto= ItemTransformer.ItemToItemResponseDto(item1);
            itemResponseDtoList.add(itemResponseDto);
        }

        cartResponseDto.setItems(itemResponseDtoList);

        return cartResponseDto;

    }
}
