package com.geekbrains.springboot.Repository;

import com.geekbrains.springboot.Entity.ConnectUserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectUserOrderRepository extends JpaRepository<ConnectUserOrder, Long> {
}
