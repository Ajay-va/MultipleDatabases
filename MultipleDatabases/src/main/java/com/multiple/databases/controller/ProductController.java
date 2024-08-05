package com.multiple.databases.controller;

import com.multiple.databases.entities2.Product;
import com.multiple.databases.entities1.User;
import com.multiple.databases.repositories2.ProductRepository;
import com.multiple.databases.repositories1.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public Product saveProduct(@RequestBody Product product){

        product=productRepository.save(product);

        return product;

    }

    @PostMapping("/userCreate")
    public User saveProduct(@RequestBody User user){

        user=userRepository.save(user);

        return user;

    }



}
