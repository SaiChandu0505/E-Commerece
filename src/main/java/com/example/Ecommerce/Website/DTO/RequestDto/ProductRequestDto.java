package com.example.Ecommerce.Website.DTO.RequestDto;

import com.example.Ecommerce.Website.Enum.ProductCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class ProductRequestDto {

    int sellerId;

    String productName;

    int price;

    int quantity;

    ProductCategory productCategory;
}
