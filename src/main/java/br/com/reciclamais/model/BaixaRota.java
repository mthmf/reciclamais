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

import br.com.reciclamais.util.LocalDateTimeDeserializer;
import br.com.reciclamais.util.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="baixa_rota")
@SequenceGenerator(name = "seq_baixa_rota",sequenceName = "seq_baixa_rota",allocationSize = 1)
public class BaixaRota {
	
	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_baixa_rota")	
	private Integer codigo;
	
	@Column(name="codigo_rota")
	private Integer codigoRota;
	
	@Column(name="dataBaixa")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dataBaixa;
	
	@Column(name="data_saida")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dataSaida;
	
	@Column(name="dataChegada")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dataChegada;
	
	@Column(name="observacao")
	private String observacao;
	
}
