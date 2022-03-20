package com.oraclesample.oraclesec.controller;

import com.oraclesample.oraclesec.model.*;
import com.oraclesample.oraclesec.repository.CartItemRepository;
import com.oraclesample.oraclesec.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class CartController {

    private final int delivery_Date = 7;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    CouponService couponService;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    CartItemService cartItemService;

    @Autowired
    OrderDetailsService orderDetailsService;

    @PostMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id, @RequestParam("quantity") int quantity){
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Product product = productService.show(id);
        User user = userService.getAuthUser(auth);
        cartItemService.addCartProduct(user,product,quantity);
        return "redirect:/shop";
    }


    @GetMapping("/cart-minus/{id}")
    public String updateMinusCart(@PathVariable int id) {
        CartItem cartItem = cartItemService.show(id);
        int total = cartItem.getQuantity() - 1;
        cartItem.setQuantity(total);
        cartItemService.save(cartItem);
        return "redirect:/cart";
    }

    @GetMapping("/cart-add/{id}")
    public String updateAddCart(@PathVariable int id) {
        CartItem cartItem = cartItemService.show(id);
        int total = cartItem.getQuantity() + 1;
        cartItem.setQuantity(total);
        cartItemService.save(cartItem);
        return "redirect:/cart";
    }

    @GetMapping("/destroy-cart-item")
    public String delete(int id) {
        cartItemService.removeCartItemById(id);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cart(Model model,  @RequestParam("couponName") Optional<String> couponName){
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        double total = 0;
        User user = userService.getAuthUser(auth);
        List<CartItem> cartItem = cartItemService.index(user, "IC");
        if (cartItem.isEmpty()) {
            model.addAttribute("cartItem", "NoData");
        } else {
            total = cartItem.stream().map(item -> item.getProduct().getPrice() * item.getQuantity())
                    .mapToDouble(num -> num.doubleValue()).sum();
            model.addAttribute("cartItem", cartItem);
        }
        model.addAttribute("user", user);
        model.addAttribute("total", total);
        return "/user/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model){
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getAuthUser(auth);
        List<CartItem> cartItem = cartItemService.index(user,"IC");
        double total = 0;
        total = cartItem.stream().map(item -> item.getProduct().getPrice() * item.getQuantity())
                .mapToDouble(num -> num.doubleValue()).sum();
        if (cartItem.isEmpty()) {
            model.addAttribute("cartItem", "NoData");
        } else {
            total = cartItem.stream().map(item -> item.getProduct().getPrice() * item.getQuantity())
                    .mapToDouble(num -> num.doubleValue()).sum();
            model.addAttribute("cartItem", cartItem);
        }
        model.addAttribute("total", total);
        model.addAttribute("cartItem", cartItem);
        model.addAttribute("user", user);
        model.addAttribute("orderDetails", new OrderDetails());
        return "/user/checkout";
    }
    @PostMapping("/checkout")
    public String checkoutPost(@RequestParam("total") Double total){
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        OrderDetails orderDetails = new OrderDetails();
        Date orderDate = Date.valueOf(LocalDate.now());
        Date deliveryDate = Date.valueOf(LocalDate.now().plusDays(delivery_Date));
        User user = userService.getAuthUser(auth);
        List<CartItem> cartItem = cartItemRepository.findByUserAndStatus(user, "IC");
        cartItem.forEach(it->it.setStatus("CO"));
        total = cartItem.stream().map(item -> item.getProduct().getPrice() * item.getQuantity())
                .mapToDouble(num -> num.doubleValue()).sum();
        orderDetails.setTotalAmount(total);
        orderDetails.setUser(user);
        orderDetails.setOrderDate(orderDate);
        orderDetails.setDeliveryDate(deliveryDate);
        orderDetailsService.save(orderDetails);
        return"redirect:/cart";
    }
}
