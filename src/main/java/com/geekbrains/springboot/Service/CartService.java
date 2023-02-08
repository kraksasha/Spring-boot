package com.geekbrains.springboot.Service;

import com.geekbrains.springboot.Entity.ConnectUserProductCart;
import com.geekbrains.springboot.Entity.Product;
import com.geekbrains.springboot.Entity.ProductFromCart;
import com.geekbrains.springboot.Repository.CartRepository;
import com.geekbrains.springboot.Repository.ConnectUsPrRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {

    private CartRepository cartRepository;
    private UserService userService;
    private ConnectUsPrRepository connectUsPrRepository;

    public CartService(CartRepository cartRepository, UserService userService,ConnectUsPrRepository connectUsPrRepository) {
        this.cartRepository = cartRepository;
        this.userService = userService;
        this.connectUsPrRepository = connectUsPrRepository;
    }

    public ProductFromCart addToCarts(Product product){
        ProductFromCart productFromCart = new ProductFromCart();
        productFromCart.setProductId(product.getId());
        productFromCart.setProductName(product.getTitle());
        productFromCart.setProductCoast(product.getCoast());
        cartRepository.save(productFromCart);
        ConnectUserProductCart connectUserProductCart = new ConnectUserProductCart();
        connectUserProductCart.setUser_id(userService.getUserD().getId());
        connectUserProductCart.setProduct_id(productFromCart.getId());
        connectUsPrRepository.save(connectUserProductCart);
        return productFromCart;
    }

    public List<ProductFromCart> findAllToCarts(){
        return cartRepository.findAll();
    }

    public void deleteProductToCart(Long id){
        cartRepository.deleteById(id);
    }
}
