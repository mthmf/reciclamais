package br.com.reciclamais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.reciclamais.model.ProdutoCarrinho;
import br.com.reciclamais.repository.ProdutoCarrinhoRepository;

@Component
public class ProdutoCarrinhoService implements IProdutoCarrinhoService {

	@Autowired
	private ProdutoCarrinhoRepository repository;
	
	@Override
	public ProdutoCarrinho getProdutoCarrinhoById(Integer codigo) {
		Optional<ProdutoCarrinho> item = repository.findById(codigo);
		if(item.isPresent()) {
			return item.get();		
		}
		return null;
	}

	@Override
	public boolean adicionaProduto(ProdutoCarrinho produtoCarrinho) {
		return repository.save(produtoCarrinho) != null;
	}

	@Override
	public List<ProdutoCarrinho> findByCodigoCarrinho(Integer codigoCarrinho) {
		return repository.findByCodigoCarrinho(codigoCarrinho);
	}

	
	
}
