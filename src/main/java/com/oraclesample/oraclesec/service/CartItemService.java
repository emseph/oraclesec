package com.oraclesample.oraclesec.service;

import com.oraclesample.oraclesec.model.CartItem;
import com.oraclesample.oraclesec.model.Product;
import com.oraclesample.oraclesec.model.User;
import com.oraclesample.oraclesec.repository.CartItemRepository;
import com.oraclesample.oraclesec.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

//    public List<CartItem> indexStatus(User user, String status){
//        return cartItemRepository.findByUserStatus(user, status);
//    }

    public List<CartItem> index(User user) {
        return cartItemRepository.findByUser(user);
    }

    public CartItem show(int id) {
        Optional<CartItem> optional = cartItemRepository.findById(id);
        CartItem cartItem = null;
        if (optional.isPresent()) {
            cartItem = optional.get();
        } else {
            throw new RuntimeException(" Cartitem not found for id :: " + id);
        }
        return cartItem;
    }

    public List<CartItem> getAllCartItem(){
        return cartItemRepository.findAll();
    }

    public void addCartProduct(User user, Product product, int quantity){
        int qty = quantity;
        CartItem cartItem = cartItemRepository.findByUserAndProductAndStatus(user, product, "IC");
        if(cartItem != null){
            qty = cartItem.getQuantity() + quantity;
            cartItem.setQuantity(qty);
        }
        else {
            cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setUser(user);
            cartItem.setStatus("IC");
            cartItem.setQuantity(quantity);
        }
        cartItemRepository.save(cartItem);
    }

    public void save(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    public void removeCartItemById(int id){
        cartItemRepository.deleteById(id);
    }

}
