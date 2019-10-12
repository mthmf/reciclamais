package br.com.reciclamais.service;

import java.util.List;

import br.com.reciclamais.dto.ProdutoDTO;
import br.com.reciclamais.model.Produto;

public interface IProdutoService {

	List<Produto> getAllProduto();

	Produto getProdutoById(Integer produto);
    
	Produto getProdutoByIdentificador(String identificador);
	
	boolean adicionaProduto(ProdutoDTO produto);
    
	void alteraProduto(Produto produto);
    
	void deletaProduto(Produto produto);
}
