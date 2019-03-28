package com.dl.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dl.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {					// vai herdar funções p/ salvar, atualizar deletar...
	
	
	

}