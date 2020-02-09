package assignment.domain;

import org.springframework.data.annotation.Id;

public class Game {

    @Id
    private String id;

    public Game(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}