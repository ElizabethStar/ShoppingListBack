package com.ElizabethStar.ShoppingListBackend.controllers;


import com.ElizabethStar.ShoppingListBackend.dto.ProductDto;
import com.ElizabethStar.ShoppingListBackend.dto.ProductListAndTotalDto;
import com.ElizabethStar.ShoppingListBackend.exception.ProductDateException;
import com.ElizabethStar.ShoppingListBackend.exception.ProductNameException;
import com.ElizabethStar.ShoppingListBackend.exception.ProductNumberOfPiecesException;
import com.ElizabethStar.ShoppingListBackend.exception.ProductPriceException;
import com.ElizabethStar.ShoppingListBackend.mapper.ProductListAndTotalMapper;
import com.ElizabethStar.ShoppingListBackend.mapper.ProductMapper;
import com.ElizabethStar.ShoppingListBackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;


@RestController
@CrossOrigin("http://localhost:5173/")
public class MainController {

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public ProductListAndTotalDto GiveShoppingList(@RequestParam String selectedDate) {

        if (!Objects.equals(selectedDate, "notSelected")) {
            try {
                LocalDate date = LocalDate.parse(selectedDate);
                return ProductListAndTotalMapper.mapToProductListAndTotalDto(productService.GiveShoppingListByDate(date));
            }
            catch (DateTimeParseException e){
                System.out.println(e.getMessage());
            }
        }
        return ProductListAndTotalMapper.mapToProductListAndTotalDto(productService.GiveAllShoppingList());

    }


    @PostMapping("/products")
    public void addProduct(@RequestBody ProductDto productDto) {
        try {
            productService.addProduct(ProductMapper.mapToProduct(productDto));
        } catch (ProductPriceException | ProductNumberOfPiecesException | ProductNameException | ProductDateException e) {
            System.out.println(e.getMessage());
        }

    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable("id") long id)
    {
        productService.deleteProduct(id);

    }

}
