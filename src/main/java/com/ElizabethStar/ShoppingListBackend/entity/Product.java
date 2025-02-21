package com.ElizabethStar.ShoppingListBackend.entity;

import com.ElizabethStar.ShoppingListBackend.exception.ProductDateException;
import com.ElizabethStar.ShoppingListBackend.exception.ProductNameException;
import com.ElizabethStar.ShoppingListBackend.exception.ProductNumberOfPiecesException;
import com.ElizabethStar.ShoppingListBackend.exception.ProductPriceException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDate;


@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer numberOfPieces;
    private Double  price;
    private LocalDate date;

    public Product(String name, Integer numberOfPieces, Double price, LocalDate date) throws ProductNumberOfPiecesException, ProductPriceException, ProductNameException, ProductDateException {
            setName(name);
            setNumberOfPieces(numberOfPieces);
            setPrice(price);
            setDate(date);

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfPieces=" + numberOfPieces +
                ", price=" + price +
                ", date=" + date +
                '}';
    }


    public void setName(String name) throws ProductNameException {
        if (name==null){
            throw new ProductNameException("Название не может быть null");
        }
        this.name = name;
    }

    public void setNumberOfPieces(Integer numberOfPieces) throws ProductNumberOfPiecesException {
        if (numberOfPieces==null){
            throw new ProductNumberOfPiecesException("Количество не может быть null");
        }
        if (numberOfPieces<1){
            throw new ProductNumberOfPiecesException("Количество товаров не может быть меньше 1");
        }
        this.numberOfPieces = numberOfPieces;
    }

    public void setPrice(Double price) throws ProductPriceException {
        if (price==null){
            throw new ProductPriceException("Цена не может быть null");
        }
        if (price<0){
            throw new ProductPriceException("Цена не может быть отрицательной");
        }
        this.price = price;
    }


    public void setDate(LocalDate date) throws ProductDateException {
        if (date==null){
            throw new ProductDateException("Дата не может быть null");
        }
        this.date = date;
    }
}
