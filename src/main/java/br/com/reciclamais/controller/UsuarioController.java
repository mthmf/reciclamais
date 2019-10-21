package br.com.reciclamais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.reciclamais.model.Usuario;
import br.com.reciclamais.service.UsuarioService;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value = "/user/login", 
			  consumes= MediaType.APPLICATION_JSON_VALUE,
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.POST) 
	public ResponseEntity<Usuario> loginUsuario(@RequestBody Usuario usuario) {
		Usuario login = service.getUsuarioByLogin(usuario.getEmail(), usuario.getSenha());
		if(login == null) {
			return new ResponseEntity<Usuario>(new Usuario(), HttpStatus.OK);			
		}
		return new ResponseEntity<Usuario>(login, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/user", 
			  consumes= MediaType.APPLICATION_JSON_VALUE,
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.POST) 
	public ResponseEntity<Integer> saveUsuario(@RequestBody Usuario usuario) {
		boolean flag = service.adicionaUsuario(usuario);
        if (flag == false) {
        	return new ResponseEntity<Integer>(0 , HttpStatus.CONFLICT);
        }
		return new ResponseEntity<Integer>(usuario.getCodigo(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") Integer id) {
		Usuario usuario = service.getUsuarioById(id);
		if (usuario !=null ) {
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}
		return new ResponseEntity<Usuario>(new Usuario(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user", 
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.PUT) 
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
		service.alteraUsuario(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/user/{id}", 
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deleteUsuario(@PathVariable("id") Integer id) {
		Usuario usuario = service.getUsuarioById(id);
		service.deletaUsuario(usuario);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
