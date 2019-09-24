package br.com.reciclamais.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.reciclamais.model.Produto;

public interface ProdutoRepository  extends CrudRepository<Produto, Integer>{

}
