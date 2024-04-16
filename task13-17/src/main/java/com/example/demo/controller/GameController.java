package com.example.demo.controller;

import com.example.demo.model.DTO.GameDTO;
import com.example.demo.model.Game;
import com.example.demo.service.GameService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/add")
    public String addGame(@RequestBody GameDTO game){
        if(gameService.addGame(game)){
            return "Game added";
        }else{
            return "Game cannot be added";
        }
    }

    @PostMapping("/delete")
    public String deleteGame(@RequestBody String name){
        if(gameService.deleteGame(name)){
            return "Game deleted";
        }else{
            return "Game cannot be deleted";
        }
    }

    @GetMapping("/show")
    public List<Game> showGames(){
        return gameService.getGames();
    }

    @GetMapping("/showbyname/{name}")
    public List<Game> showGameByName(@PathVariable String name){
        return gameService.getGameByName(name);
    }

    @GetMapping("/showbydate/{date}")
    public List<Game> showGameByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return gameService.getGamesByCreationDate(date);
    }
}
