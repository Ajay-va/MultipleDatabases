package com.multiple.databases.repositories2;

import com.multiple.databases.entities2.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
