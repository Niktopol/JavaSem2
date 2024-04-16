package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Entity
@Table(name = "gamedevs")
public class GameAuthor {
    @Id
    @SequenceGenerator(name = "gamedevs_seq", sequenceName = "gamedevs_sequence", allocationSize = 1)
    @GeneratedValue(generator = "gamedevs_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Setter
    @Column(name = "nickname")
    private String nickname;

    @Setter
    @Column(name = "birthdate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Setter
    @JsonIgnoreProperties("author")
    @OneToMany(mappedBy = "author")
    private List<Game> games;

    public GameAuthor(){}

    public GameAuthor(String nickname, Date birthDate) {
        this.nickname = nickname;
        this.birthDate = birthDate;
    }
}
