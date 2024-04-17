package com.example.demo.model.DTO;

import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@ToString
public class GameAuthorDTO {
    private String nickname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    public GameAuthorDTO(String nickname, Date birthDate) {
        this.nickname = nickname;
        this.birthDate = birthDate;
    }
}
