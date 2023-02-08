package com.geekbrains.springboot.Entity;

import com.geekbrains.springboot.Entity.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products_from_cart")
public class ProductFromCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCoast(int productCoast) {
        this.productCoast = productCoast;
    }

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_coast")
    private int productCoast;

    @ManyToMany
    @JoinTable(name = "users_products_from_cart",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id_c"))

    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductCoast() {
        return productCoast;
    }
}
