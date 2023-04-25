package com.example.Ecommerce.Website.Transformer;

import com.example.Ecommerce.Website.DTO.RequestDto.ProductRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.ProductResponseDto;
import com.example.Ecommerce.Website.Entity.Product;
import com.example.Ecommerce.Website.Enum.ProductStatus;

public class ProductTransformer {
    public static Product ProductRequestDtoToProduct(ProductRequestDto productRequestDto){

        return Product.builder()
                .productName(productRequestDto.getProductName())
                .price(productRequestDto.getPrice())
                .productCategory(productRequestDto.getProductCategory())
                .quantity(productRequestDto.getQuantity())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }

    public static ProductResponseDto ProductToProductResponseDto(Product product){
        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .sellerName(product.getSeller().getName())
                .quantity(product.getQuantity())
                .productStatus(product.getProductStatus())
                .build();
    }
}
