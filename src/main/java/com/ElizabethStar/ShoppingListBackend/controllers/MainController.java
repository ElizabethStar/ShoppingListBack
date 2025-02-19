package com.ElizabethStar.ShoppingListBackend.controllers;

import com.ElizabethStar.ShoppingListBackend.dto.ProductDto;
import com.ElizabethStar.ShoppingListBackend.mapper.ProductMapper;
import com.ElizabethStar.ShoppingListBackend.repository.ProductRepository;
import com.ElizabethStar.ShoppingListBackend.services.ProductService;
import com.ElizabethStar.ShoppingListBackend.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@RestController
@CrossOrigin("http://localhost:5173/")
public class MainController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;




    @GetMapping("/products")
    public List<Product> GiveShoppingList(@RequestParam String selectedDate) {
        //return productService.GiveAllShoppingList();
        if (!Objects.equals(selectedDate, "notSelected")) {
            LocalDate date = LocalDate.parse(selectedDate);
            return productRepository.findByDate(date);
        }
        return productService.GiveAllShoppingList();

    }

//    @GetMapping("/products")
//    public List<Product> GiveShoppingList() {
//        //return productService.GiveAllShoppingList();
//
//        return productService.GiveAllShoppingList();
//
//    }



    @PostMapping("/products")
    public void addProduct(@RequestBody ProductDto productDto) {
        productService.addProduct(ProductMapper.mapToProduct(productDto));
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable("id") long id)
    {
        productService.deleteProduct(id);

    }

}
