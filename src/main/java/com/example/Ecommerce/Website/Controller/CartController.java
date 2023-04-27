package com.example.Ecommerce.Website.Controller;

import com.example.Ecommerce.Website.DTO.RequestDto.ItemRequestDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.CartResponseDto;
import com.example.Ecommerce.Website.DTO.ResponseDto.ItemResponseDto;
import com.example.Ecommerce.Website.Entity.Item;
import com.example.Ecommerce.Website.Service.Interface.CartService;
import com.example.Ecommerce.Website.Service.Interface.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    ItemService itemService;

    @PostMapping("/add")
    public ResponseEntity addToCart(@RequestBody ItemRequestDto itemRequestDto){
        try {
            Item savedItem=itemService.addItem(itemRequestDto);
            CartResponseDto cartResponseDto=cartService.addToCart(itemRequestDto.getCustomerId(),savedItem);
            return new ResponseEntity(cartResponseDto, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-items/{customerId}")
    public ResponseEntity getItems(@PathVariable("customerId")int customerId){
        try {
            List<ItemResponseDto> itemResponseDtoList = itemService.getItems(customerId);
            return new ResponseEntity(itemResponseDtoList, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
