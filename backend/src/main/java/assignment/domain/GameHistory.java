package assignment.domain;

import org.springframework.data.annotation.Id;

public class GameHistory {

    @Id
    private final String id;
    private final String history;

    public GameHistory(String id, String history) {
        this.id = id;
        this.history = history;
    }

    public String getId() {
        return id;
    }

    public String getHistory() {
        return history;
    }
}