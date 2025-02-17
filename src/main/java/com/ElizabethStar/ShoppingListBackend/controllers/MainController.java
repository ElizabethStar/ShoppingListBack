package com.ElizabethStar.ShoppingListBackend.controllers;

import com.ElizabethStar.ShoppingListBackend.entity.Product;
import com.ElizabethStar.ShoppingListBackend.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:5173/")
public class MainController {

    @Autowired
    private ProductRepository productRep;

    @GetMapping("/products")
    public List<Product> GiveShoppingList() {

        return productRep.findAll();

    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
       // productRep.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void delete()
    {

    }

}
