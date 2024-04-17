package com.example.demo.model.DTO;

import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@ToString
public class GameDTO {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;
    private String authorNickname;

    public GameDTO(String name, Date creationDate, String authorNickname) {
        this.name = name;
        this.creationDate = creationDate;
        this.authorNickname = authorNickname;
    }
}
