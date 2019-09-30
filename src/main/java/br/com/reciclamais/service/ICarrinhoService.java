package br.com.reciclamais.service;

import java.util.List;

import br.com.reciclamais.model.Carrinho;

public interface ICarrinhoService {
	
	List<Carrinho> getAllLixeira();

	Carrinho getCarrinhoById(Integer codigo);
    
	boolean adicionaCarrinho(Carrinho carrinho);
    
	void alteraCarrinho(Carrinho carrinho);
    
	void deletaCarrinho(Carrinho carrinho);
	
	Carrinho getCarrinhoUsuario(Integer usuario);
	
}
