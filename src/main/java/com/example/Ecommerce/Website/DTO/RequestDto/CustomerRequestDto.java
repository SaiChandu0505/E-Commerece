package com.example.Ecommerce.Website.DTO.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class CustomerRequestDto {

    String name;

    String emailId;

    Integer age;

    String mobNo;

    String address;

}