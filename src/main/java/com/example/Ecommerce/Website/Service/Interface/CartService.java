package com.example.Ecommerce.Website.Service.Interface;

import com.example.Ecommerce.Website.DTO.ResponseDto.CartResponseDto;
import com.example.Ecommerce.Website.Entity.Item;

public interface CartService {
    CartResponseDto addToCart(int customerId, Item savedItem);
}
