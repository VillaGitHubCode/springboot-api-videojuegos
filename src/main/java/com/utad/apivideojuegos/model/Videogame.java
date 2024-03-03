package com.utad.apivideojuegos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "videogame")
public class Videogame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String company;
    @Column
    private Integer year;
}
