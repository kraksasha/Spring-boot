package com.geekbrains.springboot.Entity;

import javax.persistence.*;

@Entity
@Table(name = "users_products_from_cart")
public class ConnectUserProductCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    @Column(name = "user_id_c")
    private Long user_id;

    @Column(name = "product_id")
    private Long product_id;

    public Long getId() {
        return id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public Long getProduct_id() {
        return product_id;
    }
}
