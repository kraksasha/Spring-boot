package com.geekbrains.springboot.Service;

import com.geekbrains.springboot.Entity.Product;
import com.geekbrains.springboot.Repository.ProductDaoIm;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductDaoIm productDaoIm;

    public ProductService(ProductDaoIm productDaoIm) {
        this.productDaoIm = productDaoIm;
    }

    public Product saveOrUpdates(Product product){
        productDaoIm.save(product);
        return product;
    }

    public List<Product> findAll(){
        return productDaoIm.findAll();
    }

    public Optional<Product> getProductId(Long id){
        return productDaoIm.findById(id);
    }
    public void deleteId(Long id){
        productDaoIm.deleteById(id);
    }

}
