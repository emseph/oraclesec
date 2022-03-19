package com.oraclesample.oraclesec.service;

import com.oraclesample.oraclesec.model.Event;
import com.oraclesample.oraclesec.model.OrderDetails;
import com.oraclesample.oraclesec.model.User;
import com.oraclesample.oraclesec.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    public List<OrderDetails> index(User user) {
        return orderDetailsRepository.findByUser(user);
    }

    public void save(OrderDetails orderDetails) {
        orderDetailsRepository.save(orderDetails);
    }

}
