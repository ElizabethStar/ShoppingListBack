package com.ElizabethStar.ShoppingListBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;


@Getter
@Setter
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
    private Calendar date;

    public Product(String name, Integer numberOfPieces, Double price, Calendar date)
    {
        this.name=name;
        this.numberOfPieces=numberOfPieces;
        this.price=price;
        this.date=date;
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


}
