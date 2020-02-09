package assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import assignment.domain.Game;

public interface GameRepository extends MongoRepository<Game, String> {

}