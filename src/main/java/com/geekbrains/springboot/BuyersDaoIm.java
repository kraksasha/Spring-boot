package com.geekbrains.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyersDaoIm extends JpaRepository<Buyer,Long> {
}
