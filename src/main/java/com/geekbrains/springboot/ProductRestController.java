package com.geekbrains.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/rest/products")
@RestController
public class ProductRestController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public Product getProductId(@PathVariable Long id){
        return productService.getProductId(id).get();
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.findAll();
    }

    @PostMapping
    public Product addProduct(Product product){
        return productService.saveOrUpdates(product);
    }

    @DeleteMapping("/{id}")
    public int deleteProductId(@PathVariable Long id){
        productService.deleteId(id);
        return HttpStatus.OK.value();
    }

}
