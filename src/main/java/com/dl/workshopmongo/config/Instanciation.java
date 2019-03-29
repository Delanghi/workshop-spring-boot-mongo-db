package com.dl.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.dl.workshopmongo.domain.Post;
import com.dl.workshopmongo.domain.User;
import com.dl.workshopmongo.dto.AuthorDTO;
import com.dl.workshopmongo.repository.PostRepository;
import com.dl.workshopmongo.repository.UserRepository;

@Configuration																// p/ o sistema entender que se trata de uma configuração
public class Instanciation implements CommandLineRunner {
	
	@Autowired																// INSTANCIA CLASSE automaticamente
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT")); 
		
		userRepository.deleteAll(); 										// p/ deletar todos os arquivos presentes na lista
		postRepository.deleteAll(); 
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com"); 
		User alex = new User(null, "Alex Green", "alex@gmail.com"); 
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("24/02/2019"), "Partiu viagem!", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("28/02/2019"), "Bom dia!", "Acordei hoje feliz!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));		
				
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);											// p/ salvar Posts no usuário expecificado
		
	}
}