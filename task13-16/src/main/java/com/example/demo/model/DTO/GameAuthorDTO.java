package com.example.demo.model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GameAuthorDTO {
    private String nickname;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;

    public GameAuthorDTO(String nickname, Date birthDate) {
        this.nickname = nickname;
        this.birthDate = birthDate;
    }

    public String getNickname() {
        return nickname;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}
