package com.geekbrains.springboot.Repository;

import com.geekbrains.springboot.Entity.ConnectUserProductCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectUsPrRepository extends JpaRepository<ConnectUserProductCart, Long> {
}
