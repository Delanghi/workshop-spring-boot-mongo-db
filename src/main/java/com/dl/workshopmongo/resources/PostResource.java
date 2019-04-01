package com.dl.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dl.workshopmongo.domain.Post;
import com.dl.workshopmongo.services.PostService;

@RestController															// p/ informar que é um recurso REST
@RequestMapping(value="/posts")											// p/ o caminho "add ."
public class PostResource {
	
	@Autowired															// p/ INSTANCIAR CLASSE automaticamente
	private PostService service;										// associando à CLASSE UserService


 // MÉTODO PARA RETORNAR USUÁRIO A PARTIR DO ID (GET)
	@RequestMapping(value="/{id}", method=RequestMethod.GET)				// MÉTODO p/ retornar um usuário a partir do ID
	public ResponseEntity<Post> findById(@PathVariable String id) {		// "@PathVariable" p/ unir ID das linhas 35 e 36
		Post obj = service.findById(id);							
		return ResponseEntity.ok().body(obj);								// aqui retorna somente o Objeto buscado
	}
	
}