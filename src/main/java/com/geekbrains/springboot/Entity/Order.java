package com.geekbrains.springboot.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "list_product")
    private String listProduct;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "address_client")
    private String addressClient;
    @Column(name = "user_id")
    private Long userId;

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
//    @ManyToMany
//    @JoinTable(name = "users_orders",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//
//    private List<User> users;
//
//    public List<User> getUsers() {
//        return users;
//    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getListProduct() {
        return listProduct;
    }

    public void setListProduct(String listProduct) {
        this.listProduct = listProduct;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddressClient() {
        return addressClient;
    }

    public void setAddressClient(String addressClient) {
        this.addressClient = addressClient;
    }
}
