package com.geekbrains.springboot.Controller;

import com.geekbrains.springboot.Service.OrderService;
import com.geekbrains.springboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class OrderController {
    private OrderService orderService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/addOrder")
    public String addOrder(Model model){
        model.addAttribute("order", orderService.addOrder());
        return "addedOrder";
    }

    @RequestMapping("/myOrders")
    public String findOrders(Model model){
        model.addAttribute("orders", userService.findOrderListUser());
        return "showMyOrders";
    }
}
