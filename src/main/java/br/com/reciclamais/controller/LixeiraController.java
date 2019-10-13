package br.com.reciclamais.controller;

import java.util.List;

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

import br.com.reciclamais.model.Lixeira;
import br.com.reciclamais.service.LixeiraService;

@RestController
@RequestMapping("/api/v1")
public class LixeiraController {

	@Autowired
	private LixeiraService service;
	
	@RequestMapping(value = "/lixeira/all", consumes= MediaType.APPLICATION_JSON_VALUE,
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.POST) 
	public ResponseEntity<List<Lixeira>> getAllLixeiras() {
		List<Lixeira> lixeiras = service.getAllLixeiras();
		return new ResponseEntity<List<Lixeira>>(lixeiras, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/lixeira", 
			  consumes= MediaType.APPLICATION_JSON_VALUE,
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.POST) 
	public ResponseEntity<Integer> saveLixeira(@RequestBody Lixeira lixeira, UriComponentsBuilder builder) {
		boolean flag = service.adicionaLixeira(lixeira);
        if (flag == false) {
        	return new ResponseEntity<Integer>(0 , HttpStatus.CONFLICT);
        }
		return new ResponseEntity<Integer>(lixeira.getCodigo(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/lixeira/{id}", method = RequestMethod.GET)
	public ResponseEntity<Lixeira> getLixeiraById(@PathVariable("id") Integer id) {
		Lixeira lixeira = service.getLixeiraById(id);
		if (lixeira !=null ) {
			return new ResponseEntity<Lixeira>(lixeira, HttpStatus.OK);
		}
		return new ResponseEntity<Lixeira>(new Lixeira(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/lixeira", 
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.PUT) 
	public ResponseEntity<Lixeira> updateLixeira(@RequestBody Lixeira lixeira) {
		service.alteraLixeira(lixeira);
		return new ResponseEntity<Lixeira>(lixeira, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/lixeira/{id}", 
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deleteLixeira(@PathVariable("id") Integer id) {
		Lixeira lixeira = service.getLixeiraById(id);
		service.deletaLixeira(lixeira);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/lixeira/rota/{id}", 
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.GET) 
	public ResponseEntity<List<Lixeira>> getLixeirasDaRota(@PathVariable("idRota") Integer idRota) {
		List<Lixeira> lixeiras = service.getLixeirasDaRota(idRota);
		return new ResponseEntity<List<Lixeira>>(lixeiras, HttpStatus.OK);
	}
	

}
