package br.com.reciclamais.service;

import java.util.List;

import br.com.reciclamais.model.Produto;
import br.com.reciclamais.model.Usuario;

public interface IProdutoService {

	List<Produto> getAllProduto();

	Produto getProdutoById(Integer produto);
    
	boolean adicionaProduto(Produto produto, Usuario usuario);
    
	void alteraProduto(Produto produto);
    
	void deletaProduto(Produto produto);
}
