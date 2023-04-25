package com.example.Ecommerce.Website.Service.Impl;

import com.example.Ecommerce.Website.DTO.RequestDto.ProductRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.ProductResponseDto;
import com.example.Ecommerce.Website.Entity.Product;
import com.example.Ecommerce.Website.Entity.Seller;
import com.example.Ecommerce.Website.Enum.ProductCategory;
import com.example.Ecommerce.Website.ExceptionHandling.InvalidSellerException;
import com.example.Ecommerce.Website.Repository.ProductRepository;
import com.example.Ecommerce.Website.Repository.SellerRepository;
import com.example.Ecommerce.Website.Service.Interface.ProductService;
import com.example.Ecommerce.Website.Transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceimpl implements ProductService {
    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws InvalidSellerException  {

        Seller seller;
        try{
            seller =  sellerRepository.findById(productRequestDto.getSellerId()).get();
        }
        catch (Exception e){
            throw new InvalidSellerException("Seller doesn't exist");
        }

        Product product = ProductTransformer.ProductRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);

        // add product to current products of seller
        seller.getProducts().add(product);
        sellerRepository.save(seller);  // saves both seller and product

        // prepare Response Dto
        return ProductTransformer.ProductToProductResponseDto(product);
    }

    public List<ProductResponseDto> getAllProductsByCategory(ProductCategory category){

        List<Product> products = productRepository.findByProductCategory(category);

        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product product: products){
            productResponseDtos.add(ProductTransformer.ProductToProductResponseDto(product));
        }

        return productResponseDtos;
    }

    public List<ProductResponseDto> getAllProductsByPriceAndCategory(int price, String category){

        List<Product> products = productRepository.getAllProductsByPriceAndCategory(price,category);

        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product product: products){
            productResponseDtos.add(ProductTransformer.ProductToProductResponseDto(product));
        }

        return productResponseDtos;
    }
}
