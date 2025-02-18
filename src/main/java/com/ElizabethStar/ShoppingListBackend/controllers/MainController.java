package com.ElizabethStar.ShoppingListBackend.controllers;

import com.ElizabethStar.ShoppingListBackend.repository.ProductRepository;
import com.ElizabethStar.ShoppingListBackend.services.ProductService;
import com.ElizabethStar.ShoppingListBackend.entity.Product;
import com.ElizabethStar.ShoppingListBackend.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:5173/")
public class MainController {

    @Autowired
    private ProductService productService;





    @GetMapping("/products")
    public List<Product> GiveShoppingList() {
        return productService.GiveShoppingList();

    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {

    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable("id") long id)
    {
        productService.deleteProduct(id);

    }

}
