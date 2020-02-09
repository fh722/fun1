package assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import assignment.domain.GameHistory;

public interface GameHistoryRepository extends MongoRepository<GameHistory, String> {
}