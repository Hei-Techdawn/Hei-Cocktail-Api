package com.example.helloworldapi.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "coktails")
public class Cocktail  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 200)
    private String name;
    @Column(length = 250)
    private String description;
    @Transient
    private double price;
    @ManyToMany
    private List<Drinks> drinks;
}
