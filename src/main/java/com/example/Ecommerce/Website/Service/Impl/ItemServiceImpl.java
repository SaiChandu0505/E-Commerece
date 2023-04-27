package com.example.Ecommerce.Website.Service.Impl;

import com.example.Ecommerce.Website.DTO.RequestDto.ItemRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.ItemResponseDto;
import com.example.Ecommerce.Website.Entity.Customer;
import com.example.Ecommerce.Website.Entity.Item;
import com.example.Ecommerce.Website.Entity.Product;
import com.example.Ecommerce.Website.Enum.ProductStatus;
import com.example.Ecommerce.Website.ExceptionHandling.InvalidCustomerException;
import com.example.Ecommerce.Website.ExceptionHandling.InvalidProductException;
import com.example.Ecommerce.Website.ExceptionHandling.ProductOutOfStockException;
import com.example.Ecommerce.Website.Repository.CustomerRepository;
import com.example.Ecommerce.Website.Repository.ItemRepository;
import com.example.Ecommerce.Website.Repository.ProductRepository;
import com.example.Ecommerce.Website.Service.Interface.ItemService;
import com.example.Ecommerce.Website.Transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ItemServiceImpl implements ItemService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ItemRepository itemRepository;
    @Override
    public Item addItem(ItemRequestDto itemRequestDto) throws InvalidCustomerException, InvalidProductException, ProductOutOfStockException {
        Customer customer;
        try {
            customer=customerRepository.findById(itemRequestDto.getCustomerId()).get();
        }catch (Exception e){
            throw new InvalidCustomerException("Invalid Customer Id!");
        }
        Product product;
        try {
            product=productRepository.findById(itemRequestDto.getProductId()).get();
        }catch (Exception e){
            throw new InvalidProductException("Product does not exist!");
        }

        if(itemRequestDto.getRequiredQuantity() > product.getQuantity() ||
                product.getProductStatus() != ProductStatus.AVAILABLE){
            throw new ProductOutOfStockException("Product Out Of Stock!");
        }

        Item item=Item.builder()
                .requiredQuantity(itemRequestDto.getRequiredQuantity())
                .cart(customer.getCart())
                .product(product)
                .build();

        product.getItemList().add(item);
        // Product savedProduct=productRepository.save(product);

        return itemRepository.save(item);
    }

    @Override
    public List<ItemResponseDto> getItems(int customerId) throws InvalidCustomerException {
        Customer customer;
        try {
            customer = customerRepository.findById(customerId).get();
        } catch (Exception e) {
            throw new InvalidCustomerException("Invalid Customer Id!");
        }
        List<Item> items = customer.getCart().getItems();
        List<ItemResponseDto> itemResponseDtoList = new ArrayList<>();
        for (Item item : items) {
            ItemResponseDto itemResponseDto = ItemTransformer.ItemToItemResponseDto(item);
            itemResponseDtoList.add(itemResponseDto);
        }
        return itemResponseDtoList;
    }
}
