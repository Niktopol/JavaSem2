package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

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

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public GameAuthor(){}

    public GameAuthor(String nickname, Date birthDate) {
        this.nickname = nickname;
        this.birthDate = birthDate;
    }
}
