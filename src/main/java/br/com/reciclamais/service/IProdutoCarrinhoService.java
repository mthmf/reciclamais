package br.com.reciclamais.service;

import java.util.List;

import br.com.reciclamais.model.ProdutoCarrinho;

public interface IProdutoCarrinhoService {

	List<ProdutoCarrinho> findByCodigoCarrinho(Integer codigoCarrinho);
	
	ProdutoCarrinho getProdutoCarrinhoById(Integer codigo);
    
	boolean adicionaProduto(ProdutoCarrinho produtoCarrinho);
	
}
