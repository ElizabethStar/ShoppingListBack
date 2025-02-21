package com.ElizabethStar.ShoppingListBackend.repository;

import com.ElizabethStar.ShoppingListBackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByDate(LocalDate date);
}
