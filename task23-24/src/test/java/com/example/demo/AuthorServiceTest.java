package com.example.demo;

import com.example.demo.model.GameAuthor;
import com.example.demo.model.dto.GameAuthorDTO;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;
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
public class AuthorServiceTest {

    @Mock
    AuthorRepository authorRepository;

    @Test
    void add(){
        GameAuthor author1 = new GameAuthor("Petr", new Date(1000000));
        GameAuthor author2 = new GameAuthor("Kamen", new Date(1234567));

        GameAuthor author3 = new GameAuthor("Stone", new Date(2345678));

        GameAuthorDTO authordto1 = new GameAuthorDTO("Petr", new Date(1000000));
        GameAuthorDTO authordto2 = new GameAuthorDTO("Kamen", new Date(1234567));

        GameAuthorDTO authordto3 = new GameAuthorDTO("Stone", new Date(2345678));

        Mockito.when(authorRepository.findByNickname("Petr")).thenReturn(Optional.of(author1));
        Mockito.when(authorRepository.findByNickname("Stone")).thenReturn(Optional.empty());

        AuthorService authorService = new AuthorService(authorRepository);

        Assertions.assertFalse(authorService.addGamedev(authordto1));
        Assertions.assertTrue(authorService.addGamedev(authordto3));
    }
    @Test
    void delete(){
        GameAuthor author1 = new GameAuthor("Petr", new Date(1000000));
        GameAuthor author2 = new GameAuthor("Kamen", new Date(1234567));

        GameAuthor author3 = new GameAuthor("Stone", new Date(2345678));

        Mockito.when(authorRepository.findByNickname("Petr")).thenReturn(Optional.of(author1));
        Mockito.when(authorRepository.findByNickname("Stone")).thenReturn(Optional.empty());

        AuthorService authorService = new AuthorService(authorRepository);

        Assertions.assertTrue(authorService.deleteGamedev(author1.getNickname()));
        Assertions.assertFalse(authorService.deleteGamedev(author3.getNickname()));
    }
    @Test
    void getAll(){
        GameAuthor author1 = new GameAuthor("Petr", new Date(1000000));
        GameAuthor author2 = new GameAuthor("Kamen", new Date(1234567));

        GameAuthor author3 = new GameAuthor("Stone", new Date(2345678));

        Mockito.when(authorRepository.findAll()).thenReturn(List.of(author1, author2));

        AuthorService authorService = new AuthorService(authorRepository);
        Assertions.assertTrue(authorService.getGamedevs().containsAll(List.of(author1, author2)));
    }
    @Test
    void getByNick(){
        GameAuthor author1 = new GameAuthor("Petr", new Date(1000000));
        GameAuthor author2 = new GameAuthor("Kamen", new Date(1234567));

        GameAuthor author3 = new GameAuthor("Stone", new Date(2345678));

        Mockito.when(authorRepository.findByNickname("Petr")).thenReturn(Optional.of(author1));
        Mockito.when(authorRepository.findByNickname("Stone")).thenReturn(Optional.empty());

        AuthorService authorService = new AuthorService(authorRepository);

        Assertions.assertEquals(authorService.getGamedevByNickname("Petr"), author1);
        Assertions.assertNull(authorService.getGamedevByNickname("Stone"));
    }
    @Test
    void getByDate(){
        GameAuthor author1 = new GameAuthor("Petr", new Date(1000000));
        GameAuthor author2 = new GameAuthor("Kamen", new Date(1234567));

        GameAuthor author3 = new GameAuthor("Stone", new Date(2345678));

        Mockito.when(authorRepository.findAllByBirthDate(new Date(1000000))).thenReturn(List.of(author1));
        Mockito.when(authorRepository.findAllByBirthDate(new Date(2345678))).thenReturn(List.of());

        AuthorService authorService = new AuthorService(authorRepository);

        Assertions.assertEquals(authorService.getGamedevsByBirthDate(new Date(1000000)), List.of(author1));
        Assertions.assertEquals(authorService.getGamedevsByBirthDate(new Date(2345678)), List.of());
    }
}
