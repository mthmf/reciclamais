package br.com.reciclamais.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.reciclamais.model.Lixeira;
import br.com.reciclamais.model.Rota;
import br.com.reciclamais.service.RotaService;

@RestController
@RequestMapping("/api/v1")
public class RotaController {

	@Autowired
	private RotaService service;
	
	@RequestMapping(value = "/rota", 
			  consumes= MediaType.APPLICATION_JSON_VALUE,
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.POST) 
	public ResponseEntity<Integer> saveRota(@RequestBody Rota rota, UriComponentsBuilder builder) {
		boolean flag = service.adicionaRota(rota);
        if (flag == false) {
        	return new ResponseEntity<Integer>(0 , HttpStatus.CONFLICT);
        }
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(builder.path("/rota/{id}").buildAndExpand(rota.getCodigo()).toUri());

		return new ResponseEntity<Integer>(rota.getCodigo(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/rota/{id}", method = RequestMethod.GET)
	public ResponseEntity<Rota> getRotaById(@PathVariable("id") Integer id) {
		Rota rota = service.getRotaById(id);
		if (rota !=null ) {
			return new ResponseEntity<Rota>(rota, HttpStatus.OK);
		}
		return new ResponseEntity<Rota>(new Rota(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rota", 
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.PUT) 
	public ResponseEntity<Rota> updateRota(@RequestBody Rota rota) {
		service.alteraRota(rota);
		return new ResponseEntity<Rota>(rota, HttpStatus.OK);
	}
	
	
	@RequestMapping(
			  value = "/rota/{id}", 
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deleteRota(@PathVariable("id") Integer id) {
		Rota rota = service.getRotaById(id);
		service.deletaRota(rota);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rota/all", consumes= MediaType.APPLICATION_JSON_VALUE,
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.POST) 
	public ResponseEntity<List<Rota>> getAllLixeiras() {
		List<Rota> rotas = service.getAllRota();
		return new ResponseEntity<List<Rota>>(rotas, HttpStatus.CREATED);
	}

}
