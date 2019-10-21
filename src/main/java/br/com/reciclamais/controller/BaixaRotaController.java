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

import br.com.reciclamais.model.BaixaRota;
import br.com.reciclamais.service.BaixaRotaService;

@RestController
@RequestMapping("/api/v1")
public class BaixaRotaController {

	@Autowired
	private BaixaRotaService service;
	
	@RequestMapping(
			  value = "/baixarota", 
			  consumes= MediaType.APPLICATION_JSON_VALUE,
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.POST) 
	public ResponseEntity<Integer> getUsersById(@RequestBody BaixaRota baixaRota) {
		boolean flag = service.adicionaBaixaRota(baixaRota);
        if (flag == false) {
        	return new ResponseEntity<Integer>(0 , HttpStatus.CONFLICT);
        }

		return new ResponseEntity<Integer>(baixaRota.getCodigo(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/baixarota/{id}", method = RequestMethod.GET)
	public ResponseEntity<BaixaRota> getBaixaRotaById(@PathVariable("id") Integer id) {
		BaixaRota baixaRota = service.getBaixaRotaById(id);
		if (baixaRota !=null ) {
			return new ResponseEntity<BaixaRota>(baixaRota, HttpStatus.OK);
		}
		return new ResponseEntity<BaixaRota>(new BaixaRota(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/baixarota", 
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.PUT) 
	public ResponseEntity<BaixaRota> updateBaixaRota(@RequestBody BaixaRota baixaRota) {
		service.alteraBaixaRota(baixaRota);
		return new ResponseEntity<BaixaRota>(baixaRota, HttpStatus.OK);
	}
	
	
	@RequestMapping(
			  value = "/baixarota/{id}", 
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deleteBaixaRota(@PathVariable("id") Integer id) {
		BaixaRota baixaRota = service.getBaixaRotaById(id);
		service.deletaBaixaRota(baixaRota);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
