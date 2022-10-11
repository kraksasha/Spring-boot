package com.geekbrains.springboot;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> listproduct;

    public ProductRepository(){
        this.listproduct = new ArrayList<>();
    }

    public List<Product> getListproduct() {
        return listproduct;
    }

    public void setListproduct(List<Product> listproduct) {
        this.listproduct = listproduct;
    }

    public void addPoduct(Product product){
        listproduct.add(product);
    }


    public Product productForId(long id){
        for (int i = 0; i < listproduct.size(); i++){
            if (listproduct.get(i).getId() == id){
                return listproduct.get(i);
            }
        }
        return null;
    }

}
