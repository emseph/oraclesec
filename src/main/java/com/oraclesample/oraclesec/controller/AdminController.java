package com.oraclesample.oraclesec.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;


import com.oraclesample.oraclesec.model.Coupon;
import com.oraclesample.oraclesec.model.Event;
import com.oraclesample.oraclesec.model.Product;
import com.oraclesample.oraclesec.model.User;
import com.oraclesample.oraclesec.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

// import oracle.jdbc.proxy.annotation.Post;

@Controller
public class AdminController {

    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/img";

    @Autowired
    EventService eventService;

    @Autowired
    CouponService couponService;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    @GetMapping("/admin")
    public String adminHome() {
        return "/admin/index";
    }

    //
    @GetMapping("/admin/coupon")
    public String adminCoupon(Model model) {
        model.addAttribute("coupon", couponService.getAllCoupon());
        model.addAttribute("event", eventService.getAllEvent());
        return "/admin/coupon";
    }

    @GetMapping("/admin/coupon/add")
    public String adminCouponAdd(Model model) {
        model.addAttribute("coupon", new Coupon());
        model.addAttribute("event", eventService.getAllEvent());
        model.addAttribute("category",categoryService.getAllCategory());
        return "/admin/couponAdd";
    }

    @PostMapping("/admin/coupon/add")
    public String adminCouponAddPost(@ModelAttribute("coupon") Coupon coupon) {
        couponService.addCoupon(coupon);
        return "redirect:/admin/coupon";
    }

    @GetMapping("/admin/coupon/delete/{id}")
    public String deleteCoupon(@PathVariable int id) {
        couponService.removeCouponById(id);
        return "redirect:/admin/coupon";
    }

    @GetMapping("/admin/coupon/update/{id}")
    public String updateCoupon(@PathVariable int id, Model model) {
        model.addAttribute("event", eventService.getAllEvent());
        Optional<Coupon> coupon = couponService.getCouponById(id);
        if (coupon.isPresent()) {
            model.addAttribute("coupon", coupon.get());
            return "admin/couponUpdate";
        } else {
            return "404";
        }
    }

    //
    @GetMapping("/admin/event")
    public String adminEvent(Model model) {
        model.addAttribute("event", eventService.getAllEvent());
        return "/admin/event";
    }

    @GetMapping("/admin/event/add")
    public String adminEventAdd(Model model) {
        model.addAttribute("event", new Event());
        return "/admin/eventAdd";
    }

    @PostMapping("/admin/event/add")
    public String adminEventAddPost(@ModelAttribute("event") Event event) {
        eventService.addEvent(event);
        return "redirect:/admin/event";
    }

    @GetMapping("/admin/event/delete/{id}")
    public String deleteEvent(@PathVariable int id) {
        eventService.removeEventById(id);
        return "redirect:/admin/event";
    }

    @GetMapping("/admin/event/update/{id}")
    public String updateEvent(@PathVariable int id, Model model) {
        Optional<Event> event = eventService.getEventById(id);
        if (event.isPresent()) {
            model.addAttribute("event", event.get());
            return "/admin/eventUpdate";
        } else {
            return "404";
        }
    }

    //
    @GetMapping("/admin/product")
    public String adminProduct(Model model) {
        model.addAttribute("product", productService.getAllProduct());
        model.addAttribute("category", categoryService.getAllCategory());
        return "/admin/product";
    }

    @GetMapping("/admin/product/add")
    public String adminProductAdd(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("category", categoryService.getAllCategory());
        return "/admin/productAdd";
    }

    @PostMapping("/admin/product/add")
    public String adminProductAddPost(
            @ModelAttribute("product") Product product,
            @RequestParam("productImage") MultipartFile file,
            @RequestParam("imgName") String imgName) throws IOException {

        String imageUUID;
        if (!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());

        } else {
            imageUUID = imgName;
        }
        product.setImageName(imageUUID);
        productService.addProduct(product);
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProduct(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.getAllCategory());
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "/admin/productUpdate";
        } else {
            return "404";
        }
    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.removeProductById(id);
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/test")
    public String testGround(Model model){
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getAuthUser(auth);
        
        model.addAttribute("users",userService.getAllUser());
        return "/admin/test";
    }

}
