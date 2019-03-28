package com.dl.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.workshopmongo.domain.User;
import com.dl.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired														// p/ INSTANCIAR automaticamente uma CLASSE
	private UserRepository repo;									// INSTANCIAR a CLASSE UserRepository
	
	public List<User> findAll() {									// MÉTODO responsável por retornar todos os usuários do meu db
		return repo.findAll();										// MÉTODO que retorna todos os dados do Tipo User
		
	}
}