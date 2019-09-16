package br.com.reciclamais.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

	private Integer codigo;
	private String nome;
	private String fabricante;
	private BigDecimal peso;
	private LocalDate dataValidade;
}
