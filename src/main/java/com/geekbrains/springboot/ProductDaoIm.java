package com.geekbrains.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDaoIm extends JpaRepository<Product, Long> {

}
