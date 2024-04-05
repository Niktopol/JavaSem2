package com.example.demo.model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GameDTO {
    private String name;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date creationDate;
    private long authorId;

    public GameDTO(String name, Date creationDate, long authorId) {
        this.name = name;
        this.creationDate = creationDate;
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public long getAuthorId() {
        return authorId;
    }
}
