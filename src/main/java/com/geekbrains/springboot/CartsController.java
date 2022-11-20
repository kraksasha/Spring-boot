package com.geekbrains.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rest/carts")
public class CartsController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("{id}")
    public Product addToCarts(@PathVariable Long id){
        return productService.addToCarts(productService.getProductId(id).get());
    }

    @GetMapping
    public List<Product> showProductsToCart(Model model){
        return productService.findAllToCarts();
    }

    @DeleteMapping("{id}")
    public int deleteProductId(@PathVariable Long id){
        productService.deleteProductToCart(id);
        return HttpStatus.OK.value();
    }
}
