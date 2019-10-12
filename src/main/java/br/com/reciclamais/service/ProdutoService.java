package br.com.reciclamais.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.reciclamais.dto.ProdutoDTO;
import br.com.reciclamais.model.Carrinho;
import br.com.reciclamais.model.Produto;
import br.com.reciclamais.model.ProdutoCarrinho;
import br.com.reciclamais.model.Usuario;
import br.com.reciclamais.repository.ProdutoRepository;

@Component
public class ProdutoService implements IProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private CarrinhoService carrinhoService;
	
	@Autowired
	private ProdutoCarrinhoService produtoCarrinhoService;
	
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
	public boolean adicionaProduto(ProdutoDTO dto ){
		Produto produto = getProdutoById(dto.getCodigoProduto());
		Usuario usuario = usuarioService.getUsuarioById(dto.getCodigoUsuario());
		
		Carrinho carrinho = buscaCarrinhoParaProduto(produto, usuario);
		BigDecimal novoTotalPeso = carrinho.getTotalPesoReciclavel().add(produto.getPeso());
		boolean adicionadoNoCarrinho = produtoCarrinhoService.adicionaProduto(new ProdutoCarrinho(carrinho.getCodigo(), produto.getCodigo()));
			
		if(adicionadoNoCarrinho) {
			carrinho.setTotalPesoReciclavel(novoTotalPeso);
			carrinhoService.alteraCarrinho(carrinho);
			return true;
		}
		
		return false;
	}

	private Carrinho buscaCarrinhoParaProduto(Produto produto, Usuario usuario) {
		// Verifica se j� existe um carrinho aberto para o usu�rio em quest�o.
		// Se n�o existir, cria um
		Carrinho carrinho = carrinhoService.getCarrinhoUsuario(usuario.getCodigo());
		if(carrinho.getCodigo() == null || !carrinho.getAtivo()) {
			// Salva um novo carrinho
			carrinho = new Carrinho();
			carrinho.setTotalPesoReciclavel(produto.getPeso());
			carrinho.setUsuario(usuario.getCodigo());
			carrinho.setDataCriacao(LocalDateTime.now());
			carrinho.setAtivo(Boolean.TRUE);
			carrinhoService.adicionaCarrinho(carrinho);

			return carrinhoService.getCarrinhoUsuario(usuario.getCodigo());
		}
		return carrinho;
	}

	@Override
	public void alteraProduto(Produto produto) {
		repository.save(produto);
		
	}

	@Override
	public void deletaProduto(Produto produto) {
		repository.delete(produto);
	}

	@Override
	public Produto getProdutoByIdentificador(String identificador) {
		return repository.findByIdentificador(identificador);
	}
	
}
