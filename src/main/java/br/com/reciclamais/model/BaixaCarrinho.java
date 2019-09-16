package br.com.reciclamais.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaixaCarrinho {

	private Integer codigo;
	private Integer codigoLixeira;
	private Integer codigoCarrinho;
	private LocalDateTime dataAgendamento;
	private LocalDateTime dataBaixa;
	private String status;
	
}
