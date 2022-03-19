package com.oraclesample.oraclesec.controller;

import com.oraclesample.oraclesec.model.Role;
import com.oraclesample.oraclesec.model.User;
import com.oraclesample.oraclesec.repository.UserRepository;
import com.oraclesample.oraclesec.service.RoleService;
import com.oraclesample.oraclesec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class LoginController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleService roleService;


    @GetMapping("/logout")
    public String logout(){
        return "redirect: login";
    }

    @GetMapping("/login")
    public String login(){
        return "/user/login";
    }

//    @GetMapping("/default")
//    public String afterLogin(HttpServletRequest request){
//        if(request.isUserInRole("ROLE_ADMIN")){
//            return "/admin/index";
//        }
//        return "/admin";
//    }

    @GetMapping("/register")
    public String registerUser(Model model){
        model.addAttribute("user", new User());
        return "/user/register";
    }

    @PostMapping("/register")
    public String registerUserPost(
            @ModelAttribute("user") User user,
            HttpServletRequest request) throws ServletException {
        user.setEnabled(true);
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
//        List<Role> roles = new ArrayList<>();
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.show((int) 2));
        user.setRoles(roles);
        userRepository.save(user);
        request.login(user.getUsername(),password);
        return "redirect:/login";
    }
}
