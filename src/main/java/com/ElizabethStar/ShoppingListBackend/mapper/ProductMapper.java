package com.ElizabethStar.ShoppingListBackend.mapper;

import com.ElizabethStar.ShoppingListBackend.dto.ProductDto;
import com.ElizabethStar.ShoppingListBackend.entity.Product;

public class ProductMapper {
   public static ProductDto mapToProductDto(Product product){
       return new ProductDto(

               product.getName(),
               product.getNumberOfPieces(),
               product.getPrice(),
               product.getDate()

       );
   }

   public static Product mapToProduct(ProductDto productDto) {
       return new Product(
               productDto.getName(),
               productDto.getNumberOfPieces(),
               productDto.getPrice(),
               productDto.getDate()
       );
   }

}
