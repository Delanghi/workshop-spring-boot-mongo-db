package com.dl.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dl.workshopmongo.domain.User;
import com.dl.workshopmongo.dto.UserDTO;
import com.dl.workshopmongo.services.UserService;

@RestController															// p/ informar que é um recurso REST
@RequestMapping(value="/users")											// p/ o caminho "add ."
public class UserResource {
	
	@Autowired															// p/ INSTANCIAR CLASSE automaticamente
	private UserService service;										// associando à CLASSE UserService

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {					// "ResponseEntity" p/ encapsular dados
		List<User> list = service.findAll();							// p/ buscar no db de usuários e guardar nesta lista
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());				
		return ResponseEntity.ok().body(listDTO);
	}	
	
 // MÉTODO PARA RETORNAR USUÁRIO A PARTIR DO ID
	@RequestMapping(value="/{id}", method=RequestMethod.GET)				// MÉTODO p/ retornar um usuário a partir do ID
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {		// "@PathVariable" p/ unir ID das linhas 35 e 36
		User obj = service.findById(id);							
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
 // MÉTODO PARA INSERIR DADOS
	@RequestMapping(method=RequestMethod.POST)								// além do "users" deve retornar tb o ID
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {		// "void" pq a inserção recebe um Objeto vazio
		User obj = service.fromDTO(objDTO); 								// convertemos "DTO" p/ "User"
		obj = service.insert(obj);											// aqui inserimos no db
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();	
																			// acima busca o endereço do novo objeto inserido
		return ResponseEntity.created(uri).build();							// retorna a localização do novo recurso criado
	}	
	
 // MÉTODO PARA DELETAR DADOS
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)			// MÉTODO p/ retornar um usuário a partir do ID
		public ResponseEntity<Void> delete(@PathVariable String id) {		// "Void" pq ñ espera-se que retorne nenhuma informação
			service.delete(id);							
			return ResponseEntity.noContent().build();						// "noContent" resulta no código de status 204 
		}
		
 // MÉTODO PARA UPDATE (PUT)
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)			// aqui tem que expecificar o ID
		public ResponseEntity<Void> update(@RequestBody UserDTO objDTO, @PathVariable String id) {		// ter VARIÁVEL ID c/ parâmetro
			User obj = service.fromDTO(objDTO); 							// INSTANCIAMOS o obj a partir do DTO que esta na requisição (linha 59)
			obj.setId(id);													// p/ garantir que o obj vai ter o mesmo ID da requisição
			obj = service.update(obj);										// aqui executamos o update no db
			return ResponseEntity.noContent().build();						// "noContent" resulta no código de status 204 
		}
}