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

import br.com.reciclamais.model.Perfil;
import br.com.reciclamais.service.PerfilService;

@RestController
@RequestMapping("/api/v1")
public class PerfilController {

	@Autowired
	private PerfilService service;
	
	@RequestMapping(value = "/perfil", 
			  consumes= MediaType.APPLICATION_JSON_VALUE,
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.POST) 
	public ResponseEntity<Integer> getUsersById(@RequestBody Perfil perfil, UriComponentsBuilder builder) {
		boolean flag = service.adicionaPerfil(perfil);
        if (flag == false) {
        	return new ResponseEntity<Integer>(0 , HttpStatus.CONFLICT);
        }
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(builder.path("/perfil/{id}").buildAndExpand(perfil.getCodigo()).toUri());

		return new ResponseEntity<Integer>(perfil.getCodigo(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
	public ResponseEntity<Perfil> getPerfilById(@PathVariable("id") Integer id) {
		Perfil perfil = service.getPerfilById(id);
		if (perfil !=null ) {
			return new ResponseEntity<Perfil>(perfil, HttpStatus.OK);
		}
		return new ResponseEntity<Perfil>(new Perfil(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/perfil", 
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.PUT) 
	public ResponseEntity<Perfil> updatePerfil(@RequestBody Perfil perfil) {
		service.alteraPerfil(perfil);
		return new ResponseEntity<Perfil>(perfil, HttpStatus.OK);
	}
	
	
	@RequestMapping(
			  value = "/perfil/{id}", 
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deletePerfil(@PathVariable("id") Integer id) {
		Perfil perfil = service.getPerfilById(id);
		service.deletaPerfil(perfil);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
