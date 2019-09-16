package br.com.reciclamais.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rota {

	private Integer codigo;
	private String descricao;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFinal;
	
	
}
