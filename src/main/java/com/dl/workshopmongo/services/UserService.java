package com.dl.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.workshopmongo.domain.User;
import com.dl.workshopmongo.dto.UserDTO;
import com.dl.workshopmongo.repository.UserRepository;
import com.dl.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired														// p/ INSTANCIAR automaticamente uma CLASSE
	private UserRepository repo;									// INSTANCIAR a CLASSE UserRepository
	
	public List<User> findAll() {									// MÉTODO responsável por retornar todos os usuários do meu db
		return repo.findAll();										// MÉTODO que retorna todos os dados do Tipo User
	}
	
	public User findById(String id) {								// aqui se ñ existir o usuário do ID pedido, irá retornar nulo
		Optional<User> obj = repo.findById(id);  
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); 
	}	
	
 // MÉTODO PARA INSERIR DADOS
	public User insert(User obj) {														
		return repo.insert(obj);									// tem inserção de dados no pacote deste IDE
	}
	
 // MÉTODO PARA DELETAR DADOS
	public void delete(String id) {
		findById(id);												// p/ tratar a excessão caso o ID a ser deletado ñ exista
		repo.deleteById(id);
	}	
	
 // MÉTODO PARA PEGAR DTO E INSTANCIAR UM USUÁRIO
	public User fromDTO(UserDTO objDTO) {											// este MÉTODO pega o DTO e INSTANCIA um usuário
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());		// dados da "User-list"
	}
	
}