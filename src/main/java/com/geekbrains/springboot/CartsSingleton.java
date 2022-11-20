package com.geekbrains.springboot;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CartsSingleton {
    private static CartsSingleton cartsSingleton = null;
    private List<Product> list;

    public List<Product> getList() {
        return list;
    }

    private CartsSingleton() {
        list = new ArrayList<>();
    }

    public static CartsSingleton getInstance(){
        if (cartsSingleton == null){
            cartsSingleton = new CartsSingleton();
        }
        return cartsSingleton;
    }

    public void deleteProductToCartId(Long id){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == id){
                list.remove(i);
            }
        }
    }

}
