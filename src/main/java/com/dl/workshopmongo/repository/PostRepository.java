package com.dl.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.dl.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {			// vai herdar funções p/ salvar, atualizar deletar...
	
 // MÉTODO DE BUSCA
	List<Post> findByTitleContainingIgnoreCase(String text);								// p/ consulta de títulos de Post
	
 // MÉTODO DE BUSCA - QUERY
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	

}