package com.ElizabethStar.ShoppingListBackend.services.impl;

import com.ElizabethStar.ShoppingListBackend.entity.Product;
import com.ElizabethStar.ShoppingListBackend.repository.ProductRepository;
import com.ElizabethStar.ShoppingListBackend.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> GiveShoppingList() {
        return productRepository.findAll();
    }
}
