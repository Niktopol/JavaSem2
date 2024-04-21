package com.example.demo.controller;

import com.example.demo.model.dto.GameAuthorDTO;
import com.example.demo.model.GameAuthor;
import com.example.demo.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/gamedev")
public class AuthorController {
    AuthorService authorService;

    @PostMapping("/add")
    public String addGame(@RequestBody GameAuthorDTO author){
        if(authorService.addGamedev(author)){
            return "Game developer added";
        }else{
            return "Game developer cannot be added";
        }
    }

    @PostMapping("/delete")
    public String deleteGame(@RequestBody String nickname){
        if(authorService.deleteGamedev(nickname)){
            return "Game developer deleted";
        }else{
            return "Game developer cannot be deleted";
        }
    }

    @GetMapping("/show")
    public List<GameAuthor> showGamedevs(){
        return authorService.getGamedevs();
    }

    @GetMapping("/showbynick/{nickname}")
    public GameAuthor showGamedevByNickname(@PathVariable String nickname){
        return authorService.getGamedevByNickname(nickname);
    }

    @GetMapping("/showbydate/{date}")
    public List<GameAuthor> showGamedevsByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return authorService.getGamedevsByBirthDate(date);
    }
}
