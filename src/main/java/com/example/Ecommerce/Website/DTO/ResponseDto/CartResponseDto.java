package com.example.Ecommerce.Website.DTO.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CartResponseDto {
    String customerName;
    int numberOfItem;
    int totalCost;
    List<ItemResponseDto>items;
}