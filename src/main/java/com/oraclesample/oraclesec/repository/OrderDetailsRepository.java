package com.oraclesample.oraclesec.repository;

import com.oraclesample.oraclesec.model.OrderDetails;
import com.oraclesample.oraclesec.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
    public List<OrderDetails> findByUser(User user);
}
