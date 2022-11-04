package com.geekbrains.springboot;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuyersDao {

    private SessionFactoryUtils sessionFactoryUtils;

    public BuyersDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public List<String> buyersByIdProduct(Long id){
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class,id);
            String allBuyers = "";
            for (Buyer o : product.getBuyers()) {
                allBuyers += o.getName() + " ";
            }
            String s[] = allBuyers.split(" ");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < s.length; i++){
                list.add(s[i]);
            }
            return list;
        }
    }
}
