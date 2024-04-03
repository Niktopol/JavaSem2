package com.example.demo.controller;

import com.example.demo.model.DTO.GameAuthorDTO;
import com.example.demo.model.DTO.GameDTO;
import com.example.demo.model.Game;
import com.example.demo.model.GameAuthor;
import com.example.demo.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gamedev")
public class AuthorController {
    AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
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
}
