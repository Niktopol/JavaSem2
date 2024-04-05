package com.example.demo.service;

import com.example.demo.model.DTO.GameAuthorDTO;
import com.example.demo.model.Game;
import com.example.demo.model.GameAuthor;
import jakarta.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final SessionFactory sessionFactory;
    private Session session;

    public AuthorService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }


    public boolean addGamedev(GameAuthorDTO gameDTO){
        GameAuthor author = new GameAuthor(gameDTO.getNickname(), gameDTO.getBirthDate());
        var transaction = session.beginTransaction();
        if (session.createQuery("select u from GameAuthor u where u.nickname = \""+author.getNickname()+"\"", GameAuthor.class).getResultList().isEmpty()){
            session.persist(author);
            transaction.commit();
            return true;
        }else{
            transaction.commit();
            return false;
        }
    }

    public boolean deleteGamedev(String nickname){
        var transaction = session.beginTransaction();
        List<GameAuthor> games = session.createQuery("select u from GameAuthor u where u.nickname = \""+nickname+"\"", GameAuthor.class).getResultList();
        if (games.isEmpty()){
            transaction.commit();
            return false;
        }else{
            session.remove(games.get(0));
            transaction.commit();
            return true;
        }
    }

    public List<GameAuthor> getGamedevs(){
        return session.createQuery("select u from GameAuthor u", GameAuthor.class).getResultList();
    }
}
