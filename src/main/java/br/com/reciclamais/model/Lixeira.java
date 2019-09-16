package br.com.reciclamais.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lixeira {

	private Integer codigo;
	private String nomeFicticio;
	private String endereço;
	private String pontoReferencia;
	private BigDecimal capacidadeTotal;
	private BigDecimal capacidadeAtual;
	private Double latitude;
	private Double longitude;
	private Integer rota;
}
