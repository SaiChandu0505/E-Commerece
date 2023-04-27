package com.example.Ecommerce.Website.Service.Interface;

import com.example.Ecommerce.Website.DTO.RequestDto.ItemRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.ItemResponseDto;
import com.example.Ecommerce.Website.Entity.Item;
import com.example.Ecommerce.Website.ExceptionHandling.InvalidCustomerException;
import com.example.Ecommerce.Website.ExceptionHandling.InvalidProductException;
import com.example.Ecommerce.Website.ExceptionHandling.ProductOutOfStockException;

import java.util.List;

public interface ItemService {
    Item addItem(ItemRequestDto itemRequestDto) throws InvalidProductException, InvalidCustomerException, ProductOutOfStockException, InvalidProductException, ProductOutOfStockException;

    List<ItemResponseDto> getItems(int customerId) throws InvalidCustomerException, InvalidCustomerException;
}
