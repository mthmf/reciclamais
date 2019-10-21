package br.com.reciclamais.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="lixeira")
@SequenceGenerator(name = "seq_lixeira",sequenceName = "seq_lixeira",allocationSize = 1)
public class Lixeira {

	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lixeira")	
	private Integer codigo;
	
	@Column(name="nome_fic")
	private String nomeFicticio;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="ponto_ref")
	private String pontoReferencia;
	
	@Column(name="cap_total")
	private BigDecimal capacidadeTotal;
	
	@Column(name="cap_atual")
	private BigDecimal capacidadeAtual;
	
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="longitude")
	private String longitude;
	
	@Column(name="codigo_rota")
	private Integer codigoRota;
}
