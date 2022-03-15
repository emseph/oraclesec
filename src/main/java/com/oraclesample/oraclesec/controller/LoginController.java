package com.oraclesample.oraclesec.controller;

import com.oraclesample.oraclesec.model.User;
import com.oraclesample.oraclesec.repository.UserRepository;
import com.oraclesample.oraclesec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/register")
    public String registerUserPost(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        userRepository.save(user);
        return "/user/register";
    }
}
