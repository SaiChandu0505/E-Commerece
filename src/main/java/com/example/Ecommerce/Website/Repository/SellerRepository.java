package com.example.Ecommerce.Website.Repository;

import com.example.Ecommerce.Website.Entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {
    Seller findByEmailId(String emailId);

    List<Seller> findByAge(int age);
}