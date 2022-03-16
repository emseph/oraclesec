//package com.oraclesample.oraclesec.cart;
//
//
//
//public class AddToCartDto {
//    private Integer id;
//    private  Integer userId;
//    private  Long productId;
//    private  Integer quantity;
//
//    public AddToCartDto() {
//    }
//
//    public AddToCartDto(Integer id,  Integer userId,  Long productId,  Integer quantity) {
//        this.id = id;
//        this.userId = userId;
//        this.productId = productId;
//        this.quantity = quantity;
//    }
//
//    public AddToCartDto(Cart cart) {
//        this.setId(cart.getId());
//        this.setProductId(cart.getProductId());
//        this.setUserId(cart.getUserId());
//        this.setQuantity(cart.getQuantity());
//    }
//
//    @Override
//    public String toString() {
//        return "CartDto{" +
//                "id=" + id +
//                ", userId=" + userId +
//                ", productId=" + productId +
//                ", quantity=" + quantity +
//                ",";
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public Long getProductId() {
//        return productId;
//    }
//
//    public void setProductId(Long productId) {
//        this.productId = productId;
//    }
//
//    public Integer getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Integer quantity) {
//        this.quantity = quantity;
//    }
//}
