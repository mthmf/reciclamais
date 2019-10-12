package br.com.reciclamais.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.reciclamais.model.Carrinho;
import br.com.reciclamais.model.Produto;
import br.com.reciclamais.model.ProdutoCarrinho;
import br.com.reciclamais.model.Usuario;
import br.com.reciclamais.repository.CarrinhoRepository;

@Component
public class CarrinhoService implements ICarrinhoService {

	@Autowired
	private CarrinhoRepository repository;

	@Autowired 
	private ProdutoCarrinhoService produtoCarrinhoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Override
	public List<Carrinho> getAllLixeira() {
		return (List<Carrinho>) repository.findAll();

	}
	
	public Carrinho criaNovoCarrinho(Usuario usuario) {
		// Salva um novo carrinho
		Carrinho carrinho = new Carrinho();
		carrinho.setTotalPesoReciclavel(BigDecimal.ZERO);
		carrinho.setUsuario(usuario.getCodigo());
		carrinho.setDataCriacao(LocalDateTime.now());
		carrinho.setAtivo(Boolean.TRUE);
		adicionaCarrinho(carrinho);

		return getCarrinhoUsuario(usuario.getCodigo());
	}
	
	public List<Produto> getProdutosDoCarrinho(Carrinho carrinho){
		List<ProdutoCarrinho> produtosCarrinho =  produtoCarrinhoService.findByCodigoCarrinho(carrinho.getCodigo());
		List<Produto> produtos = new ArrayList<Produto>();
		for (ProdutoCarrinho produto : produtosCarrinho ) {
			produtos.add(produtoService.getProdutoById(produto.getCodigoProduto()));
		}
		return produtos;
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

	@Override
	public Carrinho getCarrinhoUsuario(Integer usuario) {
		return repository.findByUsuarioAndAtivo(usuario, Boolean.TRUE);
	}
	
	
}
