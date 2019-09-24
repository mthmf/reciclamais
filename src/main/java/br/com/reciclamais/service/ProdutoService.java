package br.com.reciclamais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.com.reciclamais.model.Produto;
import br.com.reciclamais.repository.ProdutoRepository;

@Component
public class ProdutoService implements IProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	@Override
	public List<Produto> getAllProduto() {
		return (List<Produto>) repository.findAll();
	}

	@Override
	public Produto getProdutoById(Integer codigo) {
		Optional<Produto> produto = repository.findById(codigo);
		if(produto.isPresent()) {
			return produto.get();		
		}
		return null;
	}

	@Override
	public boolean adicionaProduto(Produto produto) {
		return repository.save(produto) != null;
	}

	@Override
	public void alteraProduto(Produto produto) {
		repository.save(produto);
		
	}

	@Override
	public void deletaProduto(Produto produto) {
		repository.delete(produto);
	}
	
}
