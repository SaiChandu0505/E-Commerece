package com.example.Ecommerce.Website.DTO.ResponseDto;

import com.example.Ecommerce.Website.Enum.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardResponseDto {

    String cardNumber;
    String customerName;
    Date expiryDate;
    CardType cardType;
}
