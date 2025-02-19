package com.ElizabethStar.ShoppingListBackend.services;

import com.ElizabethStar.ShoppingListBackend.entity.Product;

import java.util.Calendar;
import java.util.List;

public interface ProductService {
    void deleteProduct(Long id);
    List<Product> GiveAllShoppingList();
    void addProduct(Product product);

}
