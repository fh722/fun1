package assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment.domain.Game;
import assignment.repository.GameRepository;


@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public Game newGame() {
        String id = java.util.UUID.randomUUID().toString();
        Game game = repository.save(new Game(id));
        return game;
    }

    public void reset(String id) {

    }
}