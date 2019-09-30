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

import br.com.reciclamais.model.Carrinho;
import br.com.reciclamais.model.Produto;
import br.com.reciclamais.model.Usuario;
import br.com.reciclamais.service.CarrinhoService;

@RestController
@RequestMapping("/api/v1")
public class CarrinhoController {

	@Autowired
	private CarrinhoService service;
	
	@RequestMapping(value = "/carrinho/atual", 
			  consumes= MediaType.APPLICATION_JSON_VALUE,
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.POST) 
	public ResponseEntity<Carrinho> getCarrinhoAtual(@RequestBody Usuario usuario) {
		Carrinho carrinho = service.getCarrinhoUsuario(usuario.getCodigo());
		return new ResponseEntity<Carrinho>(carrinho, HttpStatus.CREATED);
	}

	
	@RequestMapping(value = "/carrinho/produtos", 
			  consumes= MediaType.APPLICATION_JSON_VALUE,
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.POST) 
	public ResponseEntity<List<Produto>> getProdutosDoCarrinho(@RequestBody Carrinho carrinho) {
		List<Produto> produtos = service.getProdutosDoCarrinho(carrinho);
		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.CREATED);
	}
	
	@RequestMapping(
			  value = "/carrinho", 
			  consumes= MediaType.APPLICATION_JSON_VALUE,
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.POST) 
	public ResponseEntity<Integer> saveCarrinho(@RequestBody Carrinho carrinho, UriComponentsBuilder builder) {
		boolean flag = service.adicionaCarrinho(carrinho);
        if (flag == false) {
        	return new ResponseEntity<Integer>(0 , HttpStatus.CONFLICT);
        }
		HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(builder.path("/carrinho/{id}").buildAndExpand(carrinho.getCodigo()).toUri());

		return new ResponseEntity<Integer>(carrinho.getCodigo(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/carrinho/{id}", method = RequestMethod.GET)
	public ResponseEntity<Carrinho> getCarrinhoById(@PathVariable("id") Integer id) {
		Carrinho carrinho = service.getCarrinhoById(id);
		if (carrinho !=null ) {
			return new ResponseEntity<Carrinho>(carrinho, HttpStatus.OK);
		}
		return new ResponseEntity<Carrinho>(new Carrinho(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/carrinho", 
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.PUT) 
	public ResponseEntity<Carrinho> updateCarrinho(@RequestBody Carrinho carrinho) {
		service.alteraCarrinho(carrinho);
		return new ResponseEntity<Carrinho>(carrinho, HttpStatus.OK);
	}
	
	@RequestMapping(
			  value = "/carrinho/{id}", 
			  produces= MediaType.APPLICATION_JSON_VALUE,
			  method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deleteCarrinho(@PathVariable("id") Integer id) {
		Carrinho carrinho = service.getCarrinhoById(id);
		service.deletaCarrinho(carrinho);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
