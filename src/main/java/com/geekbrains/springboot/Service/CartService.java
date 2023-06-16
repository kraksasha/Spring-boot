package com.geekbrains.springboot.Service;

import com.geekbrains.springboot.Entity.Product;
import com.geekbrains.springboot.Entity.ProductFromCart;
import com.geekbrains.springboot.Entity.User;
import com.geekbrains.springboot.Repository.CartRepository;
import com.geekbrains.springboot.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {

    private CartRepository cartRepository;
    private UserService userService;
    private UserRepository userRepository;
    private User user;

    public CartService(CartRepository cartRepository, UserService userService, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public ProductFromCart addToCarts(Product product){
        ProductFromCart productFromCart = new ProductFromCart();
        productFromCart.setProductId(product.getId());
        productFromCart.setProductName(product.getTitle());
        productFromCart.setProductCoast(product.getCoast());
        productFromCart.setUserId(userService.getUserD().getId());
        cartRepository.save(productFromCart);
        return productFromCart;
    }
    public void deleteProductToCart(Long id){
        cartRepository.deleteById(id);
    }

    public List<ProductFromCart> findProductListUserCart(){
        user = userRepository.findById(userService.getUserD().getId()).get();
        return user.getProductFromCarts();
    }
}
