//package com.oraclesample.oraclesec.cart;
//
//import java.util.*;
//import java.util.Date;
//
//
//
//import org.springframework.stereotype.*;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.oraclesample.oraclesec.model.Product;
//
//@Service
//@Transactional
//public class CartService {
//
//    private final CartRepository cartRepository;
//
//    public CartService(CartRepository cartRepository) {
//        this.cartRepository = cartRepository;
//    }
//
//    public void addToCart(AddToCartDto addToCartDto,int userId){
//        Cart cart = getAddToCartFromDto(addToCartDto,userId);
//        cartRepository.save(cart);
//    }
//
//    private Cart getAddToCartFromDto(AddToCartDto addToCartDto, int userId) {
//        Cart cart = new Cart(addToCartDto, userId);
//        return cart;
//    }
//
//    public CartCost listCartItems(int user_id) {
//        List<Cart> cartList = cartRepository.findAllByUserIdOrderByCreatedDateDesc(user_id);
//        List<CartDto> cartItems = new ArrayList<>();
//        for (Cart cart:cartList){
//            CartDto cartDto = getDtoFromCart(cart);
//            cartItems.add(cartDto);
//        }
//        double totalCost = 0;
//        for (CartDto cartDto:cartItems){
//            totalCost += (cartDto.getProduct().getPrice()* cartDto.getQuantity());
//        }
//        CartCost cartCost = new CartCost(cartItems,totalCost);
//        return cartCost;
//    }
//
//
//    public static CartDto getDtoFromCart(Cart cart) {
//        CartDto cartDto = new CartDto(cart);
//        return cartDto;
//    }
//
//
//    public void updateCartItem(AddToCartDto cartDto,int userId,Product product){
//        Cart cart = getAddToCartFromDto(cartDto,userId);
//        cart.setQuantity(cartDto.getQuantity());
//        cart.setUserId(userId);
//        cart.setId(cartDto.getId());
//        cart.setProductId(product.getId());
//        cart.setCreatedDate(new Date());
//        cartRepository.save(cart);
//    }
//
//    public void deleteCartItem(int id,int userId) throws CartItemNotExistException {
//        if (!cartRepository.existsById(id))
//            throw new CartItemNotExistException("Cart id is invalid : " + id);
//        cartRepository.deleteById(id);
//
//    }
//
//
//}
