package com.geekbrains.springboot.Repository;

import com.geekbrains.springboot.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    default User findByUsername(String username){
        for (int i = 0; i < findAll().size(); i++){
            if (findAll().get(i).getUsername().equals(username)){
                return findAll().get(i);
            }
        }
        return null;
    }
}
