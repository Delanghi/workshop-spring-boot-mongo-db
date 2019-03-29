package com.dl.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dl.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {			// vai herdar funções p/ salvar, atualizar deletar...
	
	
	

}