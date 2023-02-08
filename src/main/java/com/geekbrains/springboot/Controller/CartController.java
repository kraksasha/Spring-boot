package com.geekbrains.springboot.Controller;

import com.geekbrains.springboot.Entity.Product;
import com.geekbrains.springboot.Service.CartService;
import com.geekbrains.springboot.Service.ProductService;
import com.geekbrains.springboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class CartController {
    private CartService cartService;
    private ProductService productService;
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }


    @RequestMapping("/idAdd")
    public String addToCarts(Model model, @RequestParam Long id){
        Product product = productService.getProductId(id).get();
        cartService.addToCarts(product);
        return "redirect:/product/showProducts";
    }

    @RequestMapping("/cart")
    public String showProductsToCart(Model model){
        int sum = 0;
        for (int i = 0; i < userService.findProductListUserCart().size(); i++){
            sum = sum + userService.findProductListUserCart().get(i).getProductCoast();
        }
        model.addAttribute("products",userService.findProductListUserCart());
        model.addAttribute("finalPrice",sum);
        return "showProductsToCart";
    }

    @RequestMapping("/idDelete")
    public String deleteProductId(@RequestParam Long id){
        cartService.deleteProductToCart(id);
        return "redirect:/product/cart";
    }
}
