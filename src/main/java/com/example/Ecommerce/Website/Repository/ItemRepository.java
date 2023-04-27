package com.example.Ecommerce.Website.Repository;

import com.example.Ecommerce.Website.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
