package com.geekbrains.springboot;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDao {
    private final SessionFactoryUtils sessionFactoryUtils;

    public ProductDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public Product findById(Long id){
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class,id);
            session.getTransaction().commit();
            return product;
        }
    }

    public void saveOrUpdate(Product product){
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    public List<Product> findAll(){
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Product> list = session.createQuery("from Product").getResultList();
            return list;
        }
    }

    public void deleteById(Long id){
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public List<String> productsByIdBuyer(Long id){
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class,id);
            String allProducts = "";
            for (Product o : buyer.getProducts()) {
                allProducts += o.getTitle() + " ";
            }
            String s[] = allProducts.split(" ");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < s.length; i++){
                list.add(s[i]);
            }
            return list;
        }
    }
}
