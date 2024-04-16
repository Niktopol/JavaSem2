package com.example.demo.model.DTO;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
public class GameDTO {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;
    private long authorId;

    public GameDTO(String name, Date creationDate, long authorId) {
        this.name = name;
        this.creationDate = creationDate;
        this.authorId = authorId;
    }
}
