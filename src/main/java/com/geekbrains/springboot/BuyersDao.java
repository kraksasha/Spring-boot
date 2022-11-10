//package com.geekbrains.springboot;
//
//import org.hibernate.Session;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class BuyersDao {
//
//    private SessionFactoryUtils sessionFactoryUtils;
//
//    public BuyersDao(SessionFactoryUtils sessionFactoryUtils) {
//        this.sessionFactoryUtils = sessionFactoryUtils;
//    }
//
//    public List<String> buyersByIdProduct(Long id){
//        try (Session session = sessionFactoryUtils.getSession()) {
//            session.beginTransaction();
//            Product product = session.get(Product.class,id);
//            List<String> list = new ArrayList<>();
//            for (Buyer o : product.getBuyers()) {
//                list.add(o.getName());
//            }
//            return list;
//        }
//    }
//}
