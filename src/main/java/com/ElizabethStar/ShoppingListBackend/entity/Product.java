package com.ElizabethStar.ShoppingListBackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer numberOfPieces;
    private Double  price;
    private Calendar date;

}
