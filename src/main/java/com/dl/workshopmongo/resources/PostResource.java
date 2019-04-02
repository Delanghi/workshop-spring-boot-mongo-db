package com.dl.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dl.workshopmongo.domain.Post;
import com.dl.workshopmongo.resources.util.URL;
import com.dl.workshopmongo.services.PostService;

@RestController															// p/ informar que é um recurso REST
@RequestMapping(value="/posts")											// p/ o caminho "add ."
public class PostResource {
	
	@Autowired															// p/ INSTANCIAR CLASSE automaticamente
	private PostService service;										// associando à CLASSE UserService

 // MÉTODO PARA RETORNAR USUÁRIO A PARTIR DO ID (GET)
	@RequestMapping(value="/{id}", method=RequestMethod.GET)			// MÉTODO p/ retornar um usuário a partir do ID
	public ResponseEntity<Post> findById(@PathVariable String id) {		// "@PathVariable" p/ unir ID das linhas 35 e 36
		Post obj = service.findById(id);							
		return ResponseEntity.ok().body(obj);							// aqui retorna somente o Objeto buscado
	}
	
 // ENDPOINT PARA EXECUTAR AS BUSCAS
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)										// MÉTODO p/ procura de título (GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="")String text) {	// Resposta=lista de Post
		text = URL.decodeParam(text);									// aqui estamos decodificando o texto
		List<Post> list = service.findByTitle(text);					// aqui declaramos lista de post, c/ MÉTODO de procura p/ títulos
		return ResponseEntity.ok().body(list);							// retorno tem como corpo a lista solicitada
	}																	// Critério de busca = parâmetro ("?text")
	
 // ENDPOINT PARA EXECUTAR AS BUSCAS POR VÁRIOS CRITÉRIOS
	@RequestMapping(value="/fullsearch", method=RequestMethod.GET)								
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="text", defaultValue="")String text,
			@RequestParam(value="minDate", defaultValue="")String minDate,
			@RequestParam(value="maxDate", defaultValue="")String maxDate ) {		// tem 3 parâmetros
		text = URL.decodeParam(text);												// implementação; decodificar o texto
		Date min = URL.convertDate(minDate, new Date(0L));							// Argumento = menos data do sistema: 1/1/1970
		Date max = URL.convertDate(maxDate, new Date());							// caso de problema, irá gerar data atual do sistema
		List<Post> list = service.fullSearch(text, min, max);					
		return ResponseEntity.ok().body(list);							
	}	
}