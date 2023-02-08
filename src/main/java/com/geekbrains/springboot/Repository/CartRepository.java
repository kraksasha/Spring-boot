package com.geekbrains.springboot.Repository;

import com.geekbrains.springboot.Entity.ProductFromCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<ProductFromCart, Long> {

}
