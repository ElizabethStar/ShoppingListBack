package com.ElizabethStar.ShoppingListBackend.mapper;

import com.ElizabethStar.ShoppingListBackend.dto.ProductDto;
import com.ElizabethStar.ShoppingListBackend.entity.Product;
import com.ElizabethStar.ShoppingListBackend.exception.ProductDateException;
import com.ElizabethStar.ShoppingListBackend.exception.ProductNameException;
import com.ElizabethStar.ShoppingListBackend.exception.ProductNumberOfPiecesException;
import com.ElizabethStar.ShoppingListBackend.exception.ProductPriceException;

public class ProductMapper {
   public static ProductDto mapToProductDto(Product product){
       return new ProductDto(

               product.getName(),
               product.getNumberOfPieces(),
               product.getPrice(),
               product.getDate()

       );
   }

   public static Product mapToProduct(ProductDto productDto) throws ProductPriceException, ProductNumberOfPiecesException, ProductNameException, ProductDateException {

       return new Product(
               productDto.getName(),
               productDto.getNumberOfPieces(),
               productDto.getPrice(),
               productDto.getDate()
       );
   }

}
