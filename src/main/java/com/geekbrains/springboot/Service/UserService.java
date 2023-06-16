package com.geekbrains.springboot.Service;

import com.geekbrains.springboot.Entity.Order;
import com.geekbrains.springboot.Entity.ProductFromCart;
import com.geekbrains.springboot.Entity.Role;
import com.geekbrains.springboot.Repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private com.geekbrains.springboot.Entity.User userD;

    public com.geekbrains.springboot.Entity.User getUserD() {
        return userD;
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public com.geekbrains.springboot.Entity.User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        com.geekbrains.springboot.Entity.User user = findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        userD = user;
        return new
                User(user.getUsername(),
                user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }
    private Collection<? extends GrantedAuthority>
    mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new
                SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public com.geekbrains.springboot.Entity.User addUserInDB(com.geekbrains.springboot.Entity.User user){
         return userRepository.save(user);
    }
}
