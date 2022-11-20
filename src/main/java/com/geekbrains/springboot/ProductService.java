package com.geekbrains.springboot;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
//    private ProductRepository repository;
//    private final ProductDao productDao;
    private ProductDaoIm productDaoIm;
    private BuyersDaoIm buyersDaoIm;
    private CartsSingleton cartsSingleton;


    public ProductService(ProductDaoIm productDaoIm, BuyersDaoIm buyersDaoIm, CartsSingleton cartsSingleton) {
        this.productDaoIm = productDaoIm;
        this.buyersDaoIm = buyersDaoIm;
        this.cartsSingleton = cartsSingleton;
    }

    public Product saveOrUpdates(Product product){
        productDaoIm.save(product);
        return product;
    }

    public List<Product> findAll(){
        return productDaoIm.findAll();
    }

    public List<Product> findAllToCarts(){
        return cartsSingleton.getList();
    }

    public void deleteProductToCart(Long id){
        cartsSingleton.deleteProductToCartId(id);
    }

//    public ProductRepository getRepository() {
//        return repository;
//    }
//
//    @Autowired
//    public void setRepository(ProductRepository repository) {
//        this.repository = repository;
//    }

//    public void addProduct(Product product){
//        repository.addPoduct(product);
//    }

    public Optional<Product> getProductId(Long id){
        return productDaoIm.findById(id);
    }
//
    public void deleteId(Long id){
        productDaoIm.deleteById(id);
    }

    public Product addToCarts(Product product){
        cartsSingleton.getList().add(product);
        return product;
    }

//
//    public List<String> productsBuyersId(Long id){
//        Buyer buyer = buyersDaoIm.findById(id).get();
//            List<String> list = new ArrayList<>();
//            for (Product o : buyer.getProducts()) {
//                list.add(o.getTitle());
//            }
//        return list;
//    }
////
//    public List<String> buyersProductId(Long id){
//        Product product = productDaoIm.findById(id).get();
//        List<String> list = new ArrayList<>();
//        for (Buyer o : product.getBuyers()) {
//            list.add(o.getName());
//        }
//        return list;
//    }

//    public List<Product> getAll(){
//        return repository.getListproduct();
//    }
}
