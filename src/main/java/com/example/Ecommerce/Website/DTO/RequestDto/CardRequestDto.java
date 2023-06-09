package com.example.Ecommerce.Website.DTO.RequestDto;

import com.example.Ecommerce.Website.Enum.CardType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardRequestDto {
    String customerEmailId;
    String cardNumber;
    int cvv;
    Date expiryDate;
    CardType cardType;
}