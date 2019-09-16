package br.com.reciclamais.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrinho {
	
	private Integer codigo;
	private Integer usuario;
	private LocalDateTime dataCriacao;
	private BigDecimal totalPesoReciclavel;
	private Boolean ativo;

}
