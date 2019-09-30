package br.com.reciclamais.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="produto_carrinho_lixo")
@SequenceGenerator(name = "seq_produto_carrinho_lixo",sequenceName = "seq_produto_carrinho_lixo",allocationSize = 1)
public class ProdutoCarrinho {
	

	public ProdutoCarrinho(Integer codigoCarrinho, Integer codigoProduto) {
		super();
		this.codigoCarrinho = codigoCarrinho;
		this.codigoProduto = codigoProduto;
	}

	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto_carrinho_lixo")	
	private Integer codigo;
	
	
	@Column(name="codigo_carrinho_lixo")
	private Integer codigoCarrinho;
	
	@Column(name="codigo_produto")
	private Integer codigoProduto;
	
}
