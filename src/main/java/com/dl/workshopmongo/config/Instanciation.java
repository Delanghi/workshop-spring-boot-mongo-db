package com.dl.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.dl.workshopmongo.domain.User;
import com.dl.workshopmongo.repository.UserRepository;

@Configuration																// p/ o sistema entender que se trata de uma configuração
public class Instanciation implements CommandLineRunner {
	
	@Autowired																// INSTANCIA CLASSE automaticamente
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll(); 										// p/ deletar todos os arquivos presentes na lista

		User maria = new User(null, "Maria Brown", "maria@gmail.com"); 
		User alex = new User(null, "Alex Green", "alex@gmail.com"); 
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	}
}