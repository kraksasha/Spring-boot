package com.geekbrains.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RequestMapping("/product")
@Controller
public class Application {

    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
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

    @RequestMapping("/showFormRest")
    public String showFormRest(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "showFormRest";
    }

    @RequestMapping("/processForm")
    public String processForm(Product product) {
        productService.saveOrUpdates(product);
        return "processFormWithNewProduct";
    }

    @RequestMapping(path = "/showProductById", method = RequestMethod.GET)
    @ResponseBody
    public Product showProductId(Model model, @RequestParam long id){
        return productService.getProductId(id).get();
    }

    @RequestMapping("/showProducts")
    public String showProducts(Model model){
        model.addAttribute("products",productService.findAll());
        return "showProducts";
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    public String deleteId(Model model, @RequestParam Long id){
        productService.deleteId(id);
        return "redirect:/product/showProducts";
    }

    @RequestMapping("/carts")
    public String showProductsToCart(Model model){
        model.addAttribute("products",productService.findAllToCarts());
        return "showProductsToCart";
    }




//    @RequestMapping(value = "/showProductsBuyerId", method = RequestMethod.GET)
//    public String showProductsBuyersId(Model model, @RequestParam Long id){
//        model.addAttribute("products",productService.productsBuyersId(id));
//        return "showProductsBuyersIdRes";
//    }
//
//    @RequestMapping(value = "/showBuyersProductId", method = RequestMethod.GET)
//    public String showBuyersProductId(Model model, @RequestParam Long id){
//        model.addAttribute("buyers", productService.buyersProductId(id));
//        return "showBuyersProductIdRes";
//    }

}
