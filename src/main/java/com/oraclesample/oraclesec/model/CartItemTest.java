package com.oraclesample.oraclesec.model;


import javax.persistence.*;

@Entity
public class CartItemTest {

    @Id
    @SequenceGenerator(name = "CART_SEQ", sequenceName = "CART_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_SEQ")
    private int cartId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id", referencedColumnName = "product_id")
    private Coupon coupon;


//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id") )
//    private blablabla;
}
