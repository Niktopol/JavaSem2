package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @SequenceGenerator(name = "games_seq", sequenceName = "games_sequence", allocationSize = 1)
    @GeneratedValue(generator = "games_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "creationdate")
    private Date creationDate;

    @JsonIgnoreProperties("games")
    @ManyToOne
    private GameAuthor author;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public GameAuthor getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setAuthor(GameAuthor author) {
        this.author = author;
    }

    public Game(){}

    public Game(String name, Date creationDate, GameAuthor author) {
        this.name = name;
        this.creationDate = creationDate;
        this.author = author;
    }
}
