package com.geekbrains.springboot.Service;

import com.geekbrains.springboot.Entity.Order;
import com.geekbrains.springboot.Entity.ProductFromCart;
import com.geekbrains.springboot.Entity.User;
import com.geekbrains.springboot.Repository.OrderRepository;
import com.geekbrains.springboot.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private UserService userService;
    private UserRepository userRepository;
    private CartService cartService;
    private User user;

    public OrderService(OrderRepository orderRepository, UserService userService, UserRepository userRepository, CartService cartService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.userRepository = userRepository;
        this.cartService = cartService;
    }

    public Order addOrder(){
        Order order = new Order();
        String list = "";
        int sum = 0;
        for (ProductFromCart o: cartService.findProductListUserCart()){
            list = list + o.getProductName() + " ";
        }
        for (int i = 0; i < cartService.findProductListUserCart().size(); i++){
            sum = sum + cartService.findProductListUserCart().get(i).getProductCoast();
        }
        order.setListProduct(list);
        order.setClientName(userService.getUserD().getUsername());
        order.setTotalPrice(sum);
        order.setAddressClient(userService.getUserD().getAddress());
        order.setUserId(userService.getUserD().getId());
        orderRepository.save(order);
        return order;
    }

    public List<Order> findOrderListUser(){
        user = userRepository.findById(userService.getUserD().getId()).get();
        return user.getOrders();
    }
}
