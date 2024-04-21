package com.example.demo.service;

import com.example.demo.model.dto.GameAuthorDTO;
import com.example.demo.model.GameAuthor;
import com.example.demo.repository.AuthorRepository;
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
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Transactional
    public boolean addGamedev(GameAuthorDTO gameAuthorDTO){
        GameAuthor author = new GameAuthor(gameAuthorDTO.getNickname(), gameAuthorDTO.getBirthDate());
        if(authorRepository.findByNickname(author.getNickname()).isEmpty()){
            authorRepository.save(author);
            log.info("Game developer added {}", gameAuthorDTO);
            return true;
        }
        log.info("Game developer addition filed {}", gameAuthorDTO);
        return false;
    }

    @Transactional
    public boolean deleteGamedev(String nickname){
        Optional<GameAuthor> gameAuthor = authorRepository.findByNickname(nickname);
        if(gameAuthor.isPresent()){
            authorRepository.delete(gameAuthor.get());
            log.info("Game developer deleted {}", gameAuthor.get());
            return true;
        }
        log.info("Game developer deletion failed {}", nickname);
        return false;
    }

    @Transactional
    public List<GameAuthor> getGamedevs(){
        log.info("Finding all game developers");
        List<GameAuthor> l = authorRepository.findAll();
        return authorRepository.findAll();
    }

    @Transactional
    public GameAuthor getGamedevByNickname(String nickname) {
        log.info("Finding game developer by nickname {}", nickname);
        return authorRepository.findByNickname(nickname).orElse(null);
    }

    @Transactional
    public List<GameAuthor> getGamedevsByBirthDate(Date birthDate) {
        log.info("Finding game developers by birth date {}", birthDate);
        return authorRepository.findAllByBirthDate(birthDate);
    }
}
