package com.example.demo.service;

import com.example.demo.model.DTO.GameDTO;
import com.example.demo.model.Game;
import com.example.demo.model.GameAuthor;
import jakarta.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final SessionFactory sessionFactory;
    private Session session;

    public GameService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public boolean addGame(GameDTO gameDTO){
        GameAuthor author = session.createQuery("select u from GameAuthor u where u.id = :id", GameAuthor.class).setParameter("id", gameDTO.getAuthorId()).getSingleResult();
        if (author == null){
            return false;
        }
        Game game = new Game(gameDTO.getName(), gameDTO.getCreationDate(), author);
        var transaction = session.beginTransaction();
        if (session.createQuery("select u from Game u where u.name = \""+game.getName()+"\"", Game.class).getResultList().isEmpty()){
            session.persist(game);
            transaction.commit();
            return true;
        }else{
            transaction.commit();
            return false;
        }
    }

    public boolean deleteGame(String name){
        var transaction = session.beginTransaction();
        List<Game> games = session.createQuery("select u from Game u where u.name = \""+name+"\"", Game.class).getResultList();
        if (games.isEmpty()){
            transaction.commit();
            return false;
        }else{
            session.remove(games.get(0));
            transaction.commit();
            return true;
        }
    }

    public List<Game> getGames(){
        return session.createQuery("select u from Game u", Game.class).getResultList();
    }
}
