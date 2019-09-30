package br.com.reciclamais.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.reciclamais.model.ProdutoCarrinho;

public interface ProdutoCarrinhoRepository extends CrudRepository<ProdutoCarrinho, Integer> {

	List<ProdutoCarrinho> findByCodigoCarrinho(Integer codigoCarrinho);
	
}
