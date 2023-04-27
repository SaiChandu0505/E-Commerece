package com.example.Ecommerce.Website.Repository;

import com.example.Ecommerce.Website.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
