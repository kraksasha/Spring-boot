package com.geekbrains.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
//    private ProductRepository repository;
    private final ProductDao productDao;
    private final BuyersDao buyersDao;

    public ProductService(ProductDao productDao, BuyersDao buyersDao) {
        this.productDao = productDao;
        this.buyersDao = buyersDao;
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

    public List<String> productsBuyersId(Long id){
        return productDao.productsByIdBuyer(id);
    }

    public List<String> buyersProductId(Long id){
        return buyersDao.buyersByIdProduct(id);
    }

//    public List<Product> getAll(){
//        return repository.getListproduct();
//    }
}
