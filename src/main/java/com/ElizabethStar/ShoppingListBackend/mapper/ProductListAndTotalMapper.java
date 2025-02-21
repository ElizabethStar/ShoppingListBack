package com.ElizabethStar.ShoppingListBackend.mapper;

import com.ElizabethStar.ShoppingListBackend.dto.ProductListAndTotalDto;
import com.ElizabethStar.ShoppingListBackend.entity.Product;
import java.util.List;

public class ProductListAndTotalMapper {


    public static ProductListAndTotalDto mapToProductListAndTotalDto(List<Product> products){
        double total=0;
        for (Product product: products){
            total+=product.getPrice()*product.getNumberOfPieces();
        }
        return new ProductListAndTotalDto(
                products,
                total
        );
    }
}
