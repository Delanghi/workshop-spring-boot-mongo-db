package com.dl.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.workshopmongo.domain.Post;
import com.dl.workshopmongo.repository.PostRepository;
import com.dl.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired													// p/ INSTANCIAR automaticamente uma CLASSE
	private PostRepository repo;								// INSTANCIAR a CLASSE UserRepository
	
	
 // MÉTODO DE PROCURA POR ID
	public Post findById(String id) {							// aqui se ñ existir post do ID pedido, irá retornar nulo
		Optional<Post> obj = repo.findById(id);  
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); 
	}
	
 // MÉTODO DE BUSCA
 /*	public List<Post> findByTitle(String text) {
		return repo.findByTitleContainingIgnoreCase(text);
	}   */
	
 // MÉTODO DE BUSCA
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
 // MÉTODO DE BUSCA - VÁRIOS CRITÉRIOS
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24*60*60*1000);					// Acrescentando um dia+ na "maxDate", p/ garantir 24h
		return repo.fullSearch(text, minDate, maxDate); 
	}
	
}