package com.example.demo;

import com.example.demo.model.Game;
import com.example.demo.model.GameAuthor;
import com.example.demo.model.dto.GameAuthorDTO;
import com.example.demo.model.dto.GameDTO;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.GameRepository;
import com.example.demo.service.AuthorService;
import com.example.demo.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {
    @Mock
    GameRepository gameRepository;
    @Mock
    AuthorRepository authorRepository;

    @Test
    void add(){
        GameAuthor author1 = new GameAuthor("Petr", new Date(1000000));
        GameAuthor author2 = new GameAuthor("Kamen", new Date(1234567));

        GameAuthor author3 = new GameAuthor("Stone", new Date(2345678));

        Game game1 = new Game("Forza", new Date(1000000), author1);
        Game game2 = new Game("Roblox", new Date(1234567), author1);

        Game game3 = new Game("Wormix", new Date(2345678), author3);

        GameDTO gamedto1 = new GameDTO("Forza 2", new Date(2000000), "Petr");
        GameDTO gamedto2 = new GameDTO("Roblox", new Date(1234567), "Petr");

        GameDTO gamedto3 = new GameDTO("Wormix", new Date(2345678), "Stone");

        Mockito.when(authorRepository.findByNickname("Petr")).thenReturn(Optional.of(author1));
        Mockito.when(authorRepository.findByNickname("Stone")).thenReturn(Optional.empty());

        Mockito.when(gameRepository.findByName("Forza 2")).thenReturn(Optional.empty());
        Mockito.when(gameRepository.findByName("Roblox")).thenReturn(Optional.of(game2));

        GameService gameService = new GameService(gameRepository, authorRepository);

        Assertions.assertTrue(gameService.addGame(gamedto1));
        Assertions.assertFalse(gameService.addGame(gamedto2));
        Assertions.assertFalse(gameService.addGame(gamedto3));
    }
    @Test
    void delete(){
        GameAuthor author1 = new GameAuthor("Petr", new Date(1000000));
        GameAuthor author3 = new GameAuthor("Stone", new Date(2345678));

        Game game1 = new Game("Forza", new Date(1000000), author1);
        Game game2 = new Game("Roblox", new Date(1234567), author1);

        Game game3 = new Game("Wormix", new Date(2345678), author3);

        Mockito.when(gameRepository.findByName("Forza")).thenReturn(Optional.of(game1));
        Mockito.when(gameRepository.findByName("Wormix")).thenReturn(Optional.empty());

        GameService gameService = new GameService(gameRepository, authorRepository);

        Assertions.assertTrue(gameService.deleteGame(game1.getName()));
        Assertions.assertFalse(gameService.deleteGame(game3.getName()));
    }
    @Test
    void getAll(){
        GameAuthor author1 = new GameAuthor("Petr", new Date(1000000));
        GameAuthor author3 = new GameAuthor("Stone", new Date(2345678));

        Game game1 = new Game("Forza", new Date(1000000), author1);
        Game game2 = new Game("Roblox", new Date(1234567), author1);

        Game game3 = new Game("Wormix", new Date(2345678), author3);

        Mockito.when(gameRepository.findAll()).thenReturn(List.of(game1, game2));

        GameService gameService = new GameService(gameRepository, authorRepository);

        Assertions.assertTrue(gameService.getGames().containsAll(List.of(game1, game2)));
    }
    @Test
    void getByName(){
        GameAuthor author1 = new GameAuthor("Petr", new Date(1000000));
        GameAuthor author3 = new GameAuthor("Stone", new Date(2345678));

        Game game1 = new Game("Forza", new Date(1000000), author1);
        Game game2 = new Game("Roblox", new Date(1234567), author1);

        Game game3 = new Game("Wormix", new Date(2345678), author3);

        Mockito.when(gameRepository.findByName("Forza")).thenReturn(Optional.of(game1));
        Mockito.when(gameRepository.findByName("Wormix")).thenReturn(Optional.empty());

        GameService gameService = new GameService(gameRepository, authorRepository);

        Assertions.assertEquals(gameService.getGameByName("Forza"), game1);
        Assertions.assertNull(gameService.getGameByName("Wormix"));
    }
    @Test
    void getByDate(){
        GameAuthor author1 = new GameAuthor("Petr", new Date(1000000));
        GameAuthor author3 = new GameAuthor("Stone", new Date(2345678));

        Game game1 = new Game("Forza", new Date(1000000), author1);
        Game game2 = new Game("Roblox", new Date(1234567), author1);

        Game game3 = new Game("Wormix", new Date(2345678), author3);

        Mockito.when(gameRepository.findAllByCreationDate(new Date(1000000))).thenReturn(List.of(game1));
        Mockito.when(gameRepository.findAllByCreationDate(new Date(2345678))).thenReturn(List.of());

        GameService gameService = new GameService(gameRepository, authorRepository);

        Assertions.assertEquals(gameService.getGamesByCreationDate(new Date(1000000)), List.of(game1));
        Assertions.assertEquals(gameService.getGamesByCreationDate(new Date(2345678)), List.of());
    }
}
