package br.com.reciclamais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.reciclamais.model.Carrinho;
import br.com.reciclamais.repository.CarrinhoRepository;

@Component
public class CarrinhoService implements ICarrinhoService {

	@Autowired
	private CarrinhoRepository repository;

	@Override
	public List<Carrinho> getAllLixeira() {
		return (List<Carrinho>) repository.findAll();

	}

	@Override
	public Carrinho getCarrinhoById(Integer codigo) {
		Optional<Carrinho> carrinho = repository.findById(codigo);
		if(carrinho.isPresent()) {
			return carrinho.get();		
		}
		return null;
	}

	@Override
	public boolean adicionaCarrinho(Carrinho carrinho) {
		return repository.save(carrinho) != null;
	}

	@Override
	public void alteraCarrinho(Carrinho carrinho) {
		repository.save(carrinho);
		
	}

	@Override
	public void deletaCarrinho(Carrinho carrinho) {
		repository.delete(carrinho);		
	}
	
	
}
