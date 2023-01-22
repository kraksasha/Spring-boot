package com.geekbrains.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class CartController {
    private CartService cartService;
    private ProductService productService;
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
        model.addAttribute("product",product);
        return "redirect:/product/showProducts";
    }

    @RequestMapping("/cart")
    public String showProductsToCart(Model model){
        int sum = 0;
        for (int i = 0; i < cartService.findAllToCarts().size(); i++){
            sum = sum + cartService.findAllToCarts().get(i).getProductCoast();
        }
        model.addAttribute("products",cartService.findAllToCarts());
        model.addAttribute("finalPrice",sum);
        return "showProductsToCart";
    }

    @RequestMapping("/idDelete")
    public String deleteProductId(@RequestParam Long id){
        cartService.deleteProductToCart(id);
        return "redirect:/product/cart";
    }
}
