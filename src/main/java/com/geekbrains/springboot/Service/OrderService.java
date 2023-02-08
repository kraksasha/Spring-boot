package com.geekbrains.springboot.Service;

import com.geekbrains.springboot.Entity.ConnectUserOrder;
import com.geekbrains.springboot.Entity.Order;
import com.geekbrains.springboot.Entity.ProductFromCart;
import com.geekbrains.springboot.Repository.ConnectUserOrderRepository;
import com.geekbrains.springboot.Repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private UserService userService;
    private ConnectUserOrderRepository connectUserOrderRepository;

    public OrderService(OrderRepository orderRepository, UserService userService, ConnectUserOrderRepository connectUserOrderRepository) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.connectUserOrderRepository = connectUserOrderRepository;
    }

    public Order addOrder(){
        Order order = new Order();
        ConnectUserOrder connectUserOrder = new ConnectUserOrder();
        String list = "";
        int sum = 0;
        for (ProductFromCart o: userService.findProductListUserCart()){
            list = list + o.getProductName() + " ";
        }
        for (int i = 0; i < userService.findProductListUserCart().size(); i++){
            sum = sum + userService.findProductListUserCart().get(i).getProductCoast();
        }
        order.setListProduct(list);
        order.setClientName(userService.getUserD().getUsername());
        order.setTotalPrice(sum);
        order.setAddressClient(userService.getUserD().getAddress());
        orderRepository.save(order);
        connectUserOrder.setUserId(userService.getUserD().getId());
        connectUserOrder.setOrderId(order.getId());
        connectUserOrderRepository.save(connectUserOrder);
        return order;
    }
}
