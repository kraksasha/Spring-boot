package com.geekbrains.springboot.Repository;

import com.geekbrains.springboot.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDaoIm extends JpaRepository<Product, Long> {
}
