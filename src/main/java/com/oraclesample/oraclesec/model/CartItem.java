package com.oraclesample.oraclesec.model;


import javax.persistence.*;

@Entity
public class CartItem {

    @Id
    @SequenceGenerator(name = "CART_SEQ", sequenceName = "CART_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_SEQ")
    private int cartId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    private int quantity;

    @Column(columnDefinition = "varchar2(10) default 'IC'")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public CartItem() {
        super();
    }

    public CartItem(int cartId, Product product, int quantity, String status, User user) {
        this.cartId = cartId;
        this.product = product;
        this.quantity = quantity;
        this.status = status;
        this.user = user;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
