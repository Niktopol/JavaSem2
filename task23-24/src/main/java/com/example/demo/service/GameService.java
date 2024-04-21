package com.example.demo.service;

import com.example.demo.model.dto.GameDTO;
import com.example.demo.model.Game;
import com.example.demo.model.GameAuthor;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.GameRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class GameService {
    private final GameRepository gameRepository;
    private final AuthorRepository authorRepository;

    @Transactional
    public boolean addGame(GameDTO gameDTO){
        Optional<GameAuthor> gameAuthor = authorRepository.findByNickname(gameDTO.getAuthorNickname());
        if(gameAuthor.isPresent()){
            if(gameRepository.findByName(gameDTO.getName()).isEmpty()){
                gameRepository.save(new Game(gameDTO.getName(), gameDTO.getCreationDate(), gameAuthor.get()));
                log.info("Game added {}", gameDTO);
                return true;
            }
        }
        log.info("Game addition failed {}", gameDTO);
        return false;
    }

    @Transactional
    public boolean deleteGame(String name){
        Optional<Game> game = gameRepository.findByName(name);
        if(game.isPresent()){
            gameRepository.delete(game.get());
            log.info("Game deleted {}", game.get());
            return true;
        }
        log.info("Game deletion failed {}", name);
        return false;
    }

    @Transactional
    public List<Game> getGames(){
        log.info("Finding all games");
        return gameRepository.findAll();
    }

    @Transactional
    public Game getGameByName(String name) {
        log.info("Finding game by name {}", name);
        return gameRepository.findByName(name).orElse(null);
    }

    @Transactional
    public List<Game> getGamesByCreationDate(Date creationDate) {
        log.info("Finding games by creation date {}", creationDate);
        return gameRepository.findAllByCreationDate(creationDate);
    }
}
