package com.leyou.cart.controller;

import com.leyou.cart.pojo.Cart;
import com.leyou.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<Void> addCart(@RequestBody Cart cart){
        cartService.addCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Cart>> queryCart(){

        return ResponseEntity.ok(cartService.queryCart());
    }

    @PutMapping
    public ResponseEntity<Void> updateCartNum(@RequestParam("id") String skuId,@RequestParam("num") Integer num){
        cartService.updateCartGoodsNum(skuId,num);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCartGoodBySkuId(@PathVariable("id") String skuId){
        cartService.deleteCartGoodsBySkuId(skuId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
