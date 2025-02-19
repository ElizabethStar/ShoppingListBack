package com.ElizabethStar.ShoppingListBackend.dto;

import com.ElizabethStar.ShoppingListBackend.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductListAndTotalDto {
    List<Product> productList;
    double total;
}
