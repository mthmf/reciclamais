package br.com.reciclamais.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaixaRota {

	private Integer codigo;
	private Integer codigoRota;
	private LocalDateTime dataBaixa;
	private LocalDateTime dataSaida;
	private LocalDateTime dataChegada;
	private String observacao;
	
}
