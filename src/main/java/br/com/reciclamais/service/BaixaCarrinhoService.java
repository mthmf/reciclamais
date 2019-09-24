package br.com.reciclamais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.reciclamais.model.BaixaCarrinho;
import br.com.reciclamais.repository.BaixaCarrinhoRepository;

@Component
public class BaixaCarrinhoService implements IBaixaCarrinhoService {

	@Autowired
	private BaixaCarrinhoRepository repository;


	@Override
	public List<BaixaCarrinho> getAllBaixaCarrinho() {
		return (List<BaixaCarrinho>) repository.findAll();
	}

	@Override
	public BaixaCarrinho getBaixaCarrinhoById(Integer codigo) {
		// TODO Auto-generated method stub
		Optional<BaixaCarrinho> baixa = repository.findById(codigo);
		if(baixa.isPresent()) {
			return baixa.get();		
		}
		return null;
	}

	@Override
	public boolean adicionaBaixaCarrinho(BaixaCarrinho carrinho) {
		return repository.save(carrinho) != null;
	}

	@Override
	public void alteraBaixaCarrinho(BaixaCarrinho carrinho) {
		repository.save(carrinho);
		
	}

	@Override
	public void deletaBaixaCarrinho(BaixaCarrinho carrinho) {
		repository.delete(carrinho);		
		
	}
	
	
}
