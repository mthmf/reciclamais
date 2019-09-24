package br.com.reciclamais.controller;

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

import br.com.reciclamais.model.BaixaCarrinho;
import br.com.reciclamais.service.BaixaCarrinhoService;

@RestController
@RequestMapping("/api/v1")
public class BaixaCarrinhoController {

	@Autowired
	private BaixaCarrinhoService service;
	
	@RequestMapping(
			  value = "/baixacarrinho", 
			  consumes= MediaType.APPLICATION_JSON_VALUE,
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.POST) 
	public ResponseEntity<Integer> getUsersById(@RequestBody BaixaCarrinho baixaCarrinho, UriComponentsBuilder builder) {
		boolean flag = service.adicionaBaixaCarrinho(baixaCarrinho);
        if (flag == false) {
        	return new ResponseEntity<Integer>(0 , HttpStatus.CONFLICT);
        }
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(builder.path("/baixacarrinho/{id}").buildAndExpand(baixaCarrinho.getCodigo()).toUri());

		return new ResponseEntity<Integer>(baixaCarrinho.getCodigo(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/baixacarrinho/{id}", method = RequestMethod.GET)
	public ResponseEntity<BaixaCarrinho> getBaixaCarrinhoById(@PathVariable("id") Integer id) {
		BaixaCarrinho baixaCarrinho = service.getBaixaCarrinhoById(id);
		if (baixaCarrinho !=null ) {
			return new ResponseEntity<BaixaCarrinho>(baixaCarrinho, HttpStatus.OK);
		}
		return new ResponseEntity<BaixaCarrinho>(new BaixaCarrinho(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/baixacarrinho", 
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.PUT) 
	public ResponseEntity<BaixaCarrinho> updateBaixaCarrinho(@RequestBody BaixaCarrinho baixaCarrinho) {
		service.alteraBaixaCarrinho(baixaCarrinho);
		return new ResponseEntity<BaixaCarrinho>(baixaCarrinho, HttpStatus.OK);
	}
	
	
	@RequestMapping(
			  value = "/baixacarrinho/{id}", 
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deleteBaixaCarrinho(@PathVariable("id") Integer id) {
		BaixaCarrinho baixaCarrinho = service.getBaixaCarrinhoById(id);
		service.deletaBaixaCarrinho(baixaCarrinho);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
