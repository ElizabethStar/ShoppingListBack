package com.ElizabethStar.ShoppingListBackend.controllers;

import com.ElizabethStar.ShoppingListBackend.dto.ProductListAndTotalDto;
import com.ElizabethStar.ShoppingListBackend.entity.Product;
import com.ElizabethStar.ShoppingListBackend.mapper.ProductListAndTotalMapper;
import com.ElizabethStar.ShoppingListBackend.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MainControllerTest {

    @Mock
    ProductService productService;

    @InjectMocks
    MainController mainController;

    @Test
    void giveShoppingListWithDateTest() {
        Product product1 = new Product(1L,"Milk", 2,50.0, LocalDate.of(2025,2,1));
        var products=List.of(product1);
        ProductListAndTotalDto productListAndTotalDto= ProductListAndTotalMapper.mapToProductListAndTotalDto(products);

        Mockito.doReturn(products).when(this.productService).GiveShoppingListByDate(LocalDate.of(2025,2,1));
        var response =this.mainController.GiveShoppingList("2025-02-01");

        assertEquals(productListAndTotalDto.getProductList(),response.getProductList());
        assertEquals(productListAndTotalDto.getTotal(),response.getTotal());

    }

    @Test
    void giveShoppingListWithoutDateTest() {
        Product product1 = new Product(1L,"Milk", 2,50.0, LocalDate.of(2025,2,1));
        Product product2 = new Product(2L,"Apple", 1,20.0, LocalDate.of(2025,3,1));
        var products=List.of(product1,product2);
        ProductListAndTotalDto productListAndTotalDto= ProductListAndTotalMapper.mapToProductListAndTotalDto(products);

        Mockito.doReturn(products).when(this.productService).GiveAllShoppingList();
        var response =this.mainController.GiveShoppingList("notSelected");

        assertEquals(productListAndTotalDto.getProductList(),response.getProductList());
        assertEquals(productListAndTotalDto.getTotal(),response.getTotal());

    }

}