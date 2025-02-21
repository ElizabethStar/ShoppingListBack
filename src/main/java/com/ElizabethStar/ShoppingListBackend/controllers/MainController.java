package com.ElizabethStar.ShoppingListBackend.controllers;


import com.ElizabethStar.ShoppingListBackend.dto.ProductDto;
import com.ElizabethStar.ShoppingListBackend.dto.ProductListAndTotalDto;
import com.ElizabethStar.ShoppingListBackend.exception.ProductDateException;
import com.ElizabethStar.ShoppingListBackend.exception.ProductNameException;
import com.ElizabethStar.ShoppingListBackend.exception.ProductNumberOfPiecesException;
import com.ElizabethStar.ShoppingListBackend.exception.ProductPriceException;
import com.ElizabethStar.ShoppingListBackend.mapper.ProductMapper;
import com.ElizabethStar.ShoppingListBackend.repository.ProductRepository;
import com.ElizabethStar.ShoppingListBackend.services.ProductService;
import com.ElizabethStar.ShoppingListBackend.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
    public ProductListAndTotalDto GiveShoppingList(@RequestParam String selectedDate) {
        //return productService.GiveAllShoppingList();

        if (!Objects.equals(selectedDate, "notSelected")) {
            try {
                LocalDate date = LocalDate.parse(selectedDate);
                List<Product> productList = productService.GiveShoppingListByDate(date);
                ProductListAndTotalDto productListAndTotalDto = new ProductListAndTotalDto(productList,
                        productService.giveTotalPrice(productList));
                return productListAndTotalDto;
            }
            catch (DateTimeParseException e){
                System.out.println(e.getMessage());
            }
        }
        List<Product> productList = productService.GiveAllShoppingList();
        ProductListAndTotalDto productListAndTotalDto = new ProductListAndTotalDto(productList,
                productService.giveTotalPrice(productList));
        return productListAndTotalDto;

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
