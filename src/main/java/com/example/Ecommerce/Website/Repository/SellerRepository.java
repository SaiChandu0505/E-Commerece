package com.example.Ecommerce.Website.Repository;

import com.example.Ecommerce.Website.Entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {



    Seller findByEmail(String emailId);
}
