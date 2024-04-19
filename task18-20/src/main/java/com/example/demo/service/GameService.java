package com.example.demo.service;

import com.example.demo.model.DTO.GameDTO;
import com.example.demo.model.Game;
import com.example.demo.model.GameAuthor;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.GameRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class GameService {
    private final GameRepository gameRepository;
    private final AuthorRepository authorRepository;

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

    public List<Game> getGames(){
        log.info("Finding all games");
        return gameRepository.findAll();
    }

    public Game getGameByName(String name) {
        log.info("Finding game by name {}", name);
        return gameRepository.findByName(name).orElse(null);
    }

    public List<Game> getGamesByCreationDate(Date creationDate) {
        log.info("Finding games by creation date {}", creationDate);
        return gameRepository.findAllByCreationDate(creationDate);
    }
}
