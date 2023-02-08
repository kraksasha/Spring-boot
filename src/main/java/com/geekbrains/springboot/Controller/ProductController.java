package com.geekbrains.springboot.Controller;

import com.geekbrains.springboot.Entity.Product;
import com.geekbrains.springboot.Service.CartService;
import com.geekbrains.springboot.Service.ProductService;
import com.geekbrains.springboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;
    private UserService userService;

    private CartService cartService;

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/showForm")
    public String showForm(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "showForm";
    }

    @RequestMapping("/processForm")
    public String processForm(Product product) {
        productService.saveOrUpdates(product);
        return "redirect:/admin/showProductsAd";
    }

    @RequestMapping(path = "/showProductById", method = RequestMethod.GET)
    @ResponseBody
    public Product showProductId(Model model, @RequestParam long id){
        return productService.getProductId(id).get();
    }

    @RequestMapping("/showProducts")
    public String showProducts(Model model){
        model.addAttribute("products",productService.findAll());
        model.addAttribute("user",userService.getUserD());
        model.addAttribute("valueCart",userService.findProductListUserCart().size());
        return "showProducts";
    }

    @RequestMapping(value = "/deleteById")
    public String deleteId(Model model, @RequestParam Long id){
        productService.deleteId(id);
        return "redirect:/admin/showProductsAd";
    }
//    @RequestMapping(value = "/showProductsBuyerId", method = RequestMethod.GET)
//    public String showProductsBuyersId(Model model, @RequestParam Long id){
//        model.addAttribute("products",productService.productsBuyersId(id));
//        return "showProductsBuyersIdRes";
//    }

//    @RequestMapping(value = "/showBuyersProductId", method = RequestMethod.GET)
//    public String showBuyersProductId(Model model, @RequestParam Long id){
//        model.addAttribute("buyers", productService.buyersProductId(id));
//        return "showBuyersProductIdRes";
//    }
}
