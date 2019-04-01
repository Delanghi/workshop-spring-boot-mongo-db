package com.dl.workshopmongo.services;

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
	
}