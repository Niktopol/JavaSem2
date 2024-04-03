package com.example.demo.model;

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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Game(){}

    public Game(String name, Date creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }
}
