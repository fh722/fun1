package assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import assignment.domain.Game;
import assignment.domain.GameHistory;
import assignment.service.GameHistoryService;
import assignment.service.GameService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/game")
@RestController
public class GameController {


    @Autowired
    private GameService gameService;

    @Autowired
    private GameHistoryService gameHistoryService;

    @RequestMapping("/start")
    public Game start() {
        return gameService.newGame();
    }

    @RequestMapping("/reset")
    public void reset(@RequestParam(value = "id") String id) {
        gameService.reset(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestParam(value = "id", required = false) String id,
                     @RequestParam(value = "history", required = false) String history) {
        gameHistoryService.saveHistory(id);
    }

    @RequestMapping("/load")
    public GameHistory load(@RequestParam(value = "id") String id) {
        return gameHistoryService.loadHistory(id);
    }
}