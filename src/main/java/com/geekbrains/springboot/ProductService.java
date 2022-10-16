package com.geekbrains.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
//    private ProductRepository repository;
    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void saveOrUpdates(Product product){
        productDao.saveOrUpdate(product);
    }

    public List<Product> findAll(){
        return productDao.findAll();
    }

//    public ProductRepository getRepository() {
//        return repository;
//    }
//
//    @Autowired
//    public void setRepository(ProductRepository repository) {
//        this.repository = repository;
//    }

//    public void addProduct(Product product){
//        repository.addPoduct(product);
//    }

    public Product getProductId(Long id){
        return productDao.findById(id);
    }

    public void deleteId(Long id){
        productDao.deleteById(id);
    }

//    public List<Product> getAll(){
//        return repository.getListproduct();
//    }
}
