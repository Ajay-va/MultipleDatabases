package com.multiple.databases;

import com.multiple.databases.entities2.Product;
import com.multiple.databases.entities1.User;
import com.multiple.databases.repositories2.ProductRepository;
import com.multiple.databases.repositories1.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductControllerTest {


    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testMethod(){

        Product  product=new Product(1,"Apple",240000);
        productRepository.save(product);

        User user=new User(100,"AJAY","ajay@gmail.com",28);
        userRepository.save(user);


    }


}
