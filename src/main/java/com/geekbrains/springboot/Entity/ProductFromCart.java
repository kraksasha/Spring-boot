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
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_coast")
    private int productCoast;
    @Column(name = "user_id")
    private Long userId;
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
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false,updatable = false)

    private User user;

    public User getUser() {
        return user;
    }
}
