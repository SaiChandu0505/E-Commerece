package com.example.Ecommerce.Website.Service.Interface;

import com.example.Ecommerce.Website.DTO.RequestDto.ProductRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.ProductResponseDto;
import com.example.Ecommerce.Website.Enum.ProductCategory;
import com.example.Ecommerce.Website.ExceptionHandling.InvalidSellerException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {
    public ProductResponseDto addProduct(@RequestBody ProductRequestDto productRequestDto) throws InvalidSellerException;

    public List<ProductResponseDto> getAllProductsByCategory(@PathVariable("category") ProductCategory category);

    public List<ProductResponseDto> getAllProductsByPriceAndCategory(
            @PathVariable("price") int price,
            @PathVariable("category") String productCategory);
}
