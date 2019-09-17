package br.com.reciclamais.model;

import java.math.BigDecimal;
import java.time.LocalDate;

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
@Entity(name="produto")
@SequenceGenerator(name = "seq_produto",sequenceName = "seq_produto",allocationSize = 1)
public class Produto {

	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")	
	private Integer codigo;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="nome_fabricante")
	private String fabricante;
	
	@Column(name="peso")
	private BigDecimal peso;
	
	@Column(name="data_validade")
	private LocalDate dataValidade;
}
