package assignment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assignment.domain.GameHistory;
import assignment.repository.GameHistoryRepository;

@Service
public class GameHistoryService {

	@Autowired
	private GameHistoryRepository repository;

	public void saveHistory(String id) {

	}

	public GameHistory loadHistory(String id) {
		// throw not found exception
		return Optional.of(repository.findById(id).get()).orElse(null);
	}
}