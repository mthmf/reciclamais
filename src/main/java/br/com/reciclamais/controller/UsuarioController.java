package br.com.reciclamais.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.reciclamais.model.Usuario;
import br.com.reciclamais.repository.UsuarioRepository;

@Controller
@RequestMapping ("user")
public class UsuarioController {

	@Autowired 
	protected UsuarioRepository repository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getArticleById(@PathVariable("id") Integer id) {
		Optional<Usuario> usuario = repository.findById(id);
		if(usuario.isPresent()) {
			return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);			
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);			

		
	}
	
}
