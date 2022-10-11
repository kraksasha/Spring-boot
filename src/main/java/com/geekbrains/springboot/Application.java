package com.geekbrains.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/processForm")
    public String processForm(Product product) {
        productService.addProduct(product);
        return "processFormWithNewProduct";
    }

    @RequestMapping(path = "/showProductById", method = RequestMethod.GET)
    @ResponseBody
    public Product showProductId(Model model, @RequestParam long id){
        Product product  = productService.getProductId(id);
        return product;
    }

    @RequestMapping("/showProducts")
    public String showProducts(Model model){
        model.addAttribute("products",productService.getAll());
        return "showProducts";
    }

}
