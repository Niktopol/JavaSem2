package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Entity
@Table(name = "games")
public class Game {
    @Id
    @SequenceGenerator(name = "games_seq", sequenceName = "games_sequence", allocationSize = 1)
    @GeneratedValue(generator = "games_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Setter
    @Column(name = "name")
    private String name;

    @Setter
    @Column(name = "creationdate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date creationDate;

    @Setter
    @JsonIgnoreProperties("games")
    @ManyToOne
    private GameAuthor author;

    public Game(){}

    public Game(String name, Date creationDate, GameAuthor author) {
        this.name = name;
        this.creationDate = creationDate;
        this.author = author;
    }
}
