package com.geekbrains.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository repository;

    public ProductRepository getRepository() {
        return repository;
    }

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product product){
        repository.addPoduct(product);
    }

    public Product getProductId(long id){
        return repository.productForId(id);
    }

    public List<Product> getAll(){
        return repository.getListproduct();
    }
}
