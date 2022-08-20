package com.example.helloworldapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "coktails")
public class Cocktails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 200)
    private String name;
    @Column(length = 250)
    private String description;
    @ManyToMany
    private List<Drinks> drinks;
}
