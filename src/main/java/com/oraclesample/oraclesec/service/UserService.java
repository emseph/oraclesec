package com.oraclesample.oraclesec.service;

import com.oraclesample.oraclesec.model.Coupon;
import com.oraclesample.oraclesec.model.MyUserDetails;
import com.oraclesample.oraclesec.model.User;
import com.oraclesample.oraclesec.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getAuthUser(Authentication auth) {
        Object principal = auth.getPrincipal();
        return ((MyUserDetails) principal).getUser();
    }
}
