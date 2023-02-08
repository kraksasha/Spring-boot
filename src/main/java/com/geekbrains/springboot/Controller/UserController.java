package com.geekbrains.springboot.Controller;

import com.geekbrains.springboot.Entity.User;
import com.geekbrains.springboot.Service.CartService;
import com.geekbrains.springboot.Service.ProductService;
import com.geekbrains.springboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {
    private UserService userService;
    private ProductService productService;
    private CartService cartService;

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String loGin(Model model){
        return "login_page";
    }

    @RequestMapping("/registration")
    public String regNewUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "registration_page";
    }

    @RequestMapping("/addNewUser")
    public String addUser(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userService.addUserInDB(user);
        return "login_page";
    }

    @RequestMapping("/admin/showProductsAd")
    public String showProductForAdmin(Model model){
        model.addAttribute("products",productService.findAll());
        model.addAttribute("user",userService.getUserD());
        model.addAttribute("valueCart",userService.findProductListUserCart().size());
        return "showProductsForAdmin";
    }

}
