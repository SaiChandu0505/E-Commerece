package com.example.Ecommerce.Website.Entity;

import com.example.Ecommerce.Website.Enum.ProductCategory;
import com.example.Ecommerce.Website.Enum.ProductStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int price;

    int quantity;

    @Enumerated(EnumType.STRING)
    ProductCategory productCategory;

    @Enumerated(EnumType.STRING)
    ProductStatus productStatus;

    @ManyToOne
    @JoinColumn
    Seller seller;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    Item item;
}