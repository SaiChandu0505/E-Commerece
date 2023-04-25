package com.example.Ecommerce.Website.DTO.RequestDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)

public class SellerRequestDto {


    private String name;
    private int age;


    private String emailId;


    private String mobNo;


    private String panNo;
}
