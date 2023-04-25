package com.example.Ecommerce.Website.Repository;

import com.example.Ecommerce.Website.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findByMobNo(String mobNo);
}
