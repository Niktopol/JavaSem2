package com.example.demo.model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GameDTO {
    private String name;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date creationDate;

    public GameDTO(String name, Date creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
