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

import br.com.reciclamais.dto.ProdutoDTO;
import br.com.reciclamais.model.Produto;
import br.com.reciclamais.model.Usuario;
import br.com.reciclamais.service.ProdutoService;

@RestController
@RequestMapping("/api/v1")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value = "/produto", consumes= MediaType.APPLICATION_JSON_VALUE, 
			produces= MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST) 
	public ResponseEntity<Integer> saveProdutoCarrinho(@RequestBody ProdutoDTO produto) {
		boolean flag = service.adicionaProduto(produto);
        if (flag == false) {
        	return new ResponseEntity<Integer>(0 , HttpStatus.CONFLICT);
        }
		return new ResponseEntity<Integer>(produto.getCodigoProduto(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> getProdutoById(@PathVariable("id") Integer id) {
		Produto produto = service.getProdutoById(id);
		if (produto !=null ) {
			return new ResponseEntity<Produto>(produto, HttpStatus.OK);
		}
		return new ResponseEntity<Produto>(new Produto(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/produto/ident/{identificador}", method = RequestMethod.GET)
	public ResponseEntity<Produto> getProdutoByIdentificador(@PathVariable("identificador") String identificador) {
		Produto produto = service.getProdutoByIdentificador(identificador);
		if (produto !=null ) {
			return new ResponseEntity<Produto>(produto, HttpStatus.OK);
		}
		return new ResponseEntity<Produto>(new Produto(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/produto", produces= MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT) 
	public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto) {
		service.alteraProduto(produto);
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/produto/{id}", produces= MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deleteProduto(@PathVariable("id") Integer id) {
		Produto produto = service.getProdutoById(id);
		service.deletaProduto(produto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
