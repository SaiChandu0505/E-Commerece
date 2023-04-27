package com.example.Ecommerce.Website.Repository;

import com.example.Ecommerce.Website.Entity.Card;
import com.example.Ecommerce.Website.Enum.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
    List<Card> findByCardType(CardType cardType);
}