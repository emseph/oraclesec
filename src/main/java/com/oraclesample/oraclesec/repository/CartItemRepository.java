package com.oraclesample.oraclesec.repository;

import com.oraclesample.oraclesec.model.CartItem;
import com.oraclesample.oraclesec.model.Product;
import com.oraclesample.oraclesec.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    public List<CartItem> findByUserAndStatus(User user, String status);
    public List<CartItem> findByUser(User user);
    public CartItem findByUserAndProductAndStatus(User user, Product product, String status);
}
