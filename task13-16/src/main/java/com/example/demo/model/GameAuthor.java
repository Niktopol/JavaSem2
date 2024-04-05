package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "gamedevs")
public class GameAuthor {
    @Id
    @SequenceGenerator(name = "gamedevs_seq", sequenceName = "gamedevs_sequence", allocationSize = 1)
    @GeneratedValue(generator = "gamedevs_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "nickname")
    private String nickname;

    @Column(name = "birthdate")
    private Date birthDate;

    @JsonIgnoreProperties("author")
    @OneToMany(mappedBy = "author")
    private List<Game> games;

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public GameAuthor(){}

    public GameAuthor(String nickname, Date birthDate) {
        this.nickname = nickname;
        this.birthDate = birthDate;
    }
}
