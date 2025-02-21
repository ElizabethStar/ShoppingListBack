package com.ElizabethStar.ShoppingListBackend.services;

import com.ElizabethStar.ShoppingListBackend.entity.Product;

import java.time.LocalDate;
import java.util.List;

public interface ProductService {
    void deleteProduct(Long id);
    List<Product> GiveAllShoppingList();
    void addProduct(Product product);
    List<Product> GiveShoppingListByDate(LocalDate date);

}
