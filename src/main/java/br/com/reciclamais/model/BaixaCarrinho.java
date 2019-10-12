package br.com.reciclamais.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="baixa_carrinho")
@SequenceGenerator(name = "seq_baixa_carrinho",sequenceName = "seq_baixa_carrinho",allocationSize = 1)
public class BaixaCarrinho {

	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_baixa_carrinho")	
	private Integer codigo;
	
	@Column(name="codigo_lixeira")
	private Integer codigoLixeira;
	
	@Column(name="codigo_carrinho")
	private Integer codigoCarrinho;
	
	@Column(name="data_agendamento")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dataAgendamento;
	
	@Column(name="data_baixa")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dataBaixa;
	
	@Column(name="status")
	private String status;
	
}
