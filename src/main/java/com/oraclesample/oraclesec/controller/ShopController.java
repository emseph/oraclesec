package com.oraclesample.oraclesec.controller;

import com.oraclesample.oraclesec.service.CategoryService;
import com.oraclesample.oraclesec.service.ProductService;
import com.oraclesample.oraclesec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @GetMapping({ "/", "/home" })
    public String home(Model model) {
        model.addAttribute("category", categoryService.getAllCategory());
        model.addAttribute("product", productService.getAllProduct());
        System.out.println(userService.getAllUser());
        return "/user/index";
    }

    @GetMapping({ "/shop" })
    public String shop(Model model) {
        model.addAttribute("category", categoryService.getAllCategory());
        model.addAttribute("product", productService.getAllProduct());
        model.addAttribute("users", userService.getAllUser());
        return "/user/index";
    }

    @GetMapping({ "/shop/category/{id}" })
    public String shopByCategory(Model model, @PathVariable int id) {
        model.addAttribute("category", categoryService.getAllCategory());
        model.addAttribute("product",
                productService.getAllProductByCategoryId(id));
        return "/user/index";
    }

    @GetMapping("/shop/product/{id}")
    public String viewProduct(Model model, @PathVariable int id) {
        model.addAttribute("category", categoryService.getAllCategory());
        // model.addAttribute("product", productService.getAllProduct());
        model.addAttribute("product", productService.getProductById(id).get());
        model.addAttribute("users", userService.getAllUser());
        return "/user/viewProduct";
    }

    @GetMapping("/register")
    public String registerUser(Model model) {
        return "/user/register";
    }



    // @GetMapping(value = "/")
    // public String () {
    // return "index";
    // }
}
