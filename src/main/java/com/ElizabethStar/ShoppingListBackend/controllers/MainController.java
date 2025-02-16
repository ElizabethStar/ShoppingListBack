package com.ElizabethStar.ShoppingListBackend.controllers;

import com.ElizabethStar.ShoppingListBackend.entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.GregorianCalendar;


@RestController
public class MainController {


    @GetMapping("/products")
    public void GiveShoppingList() {

    }

    @PostMapping("/products")
    public void add() {

    }

    @DeleteMapping("/products/{id}")
    public void delete()
    {

    }

}
