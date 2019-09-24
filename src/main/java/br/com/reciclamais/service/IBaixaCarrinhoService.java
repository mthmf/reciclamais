package br.com.reciclamais.service;

import java.util.List;

import br.com.reciclamais.model.BaixaCarrinho;

public interface IBaixaCarrinhoService {
	
	List<BaixaCarrinho> getAllBaixaCarrinho();

	BaixaCarrinho getBaixaCarrinhoById(Integer codigo);
    
	boolean adicionaBaixaCarrinho(BaixaCarrinho carrinho);
    
	void alteraBaixaCarrinho(BaixaCarrinho carrinho);
    
	void deletaBaixaCarrinho(BaixaCarrinho carrinho);
	
}
