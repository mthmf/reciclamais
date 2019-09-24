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
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="rota")
@SequenceGenerator(name = "seq_rota",sequenceName = "seq_rota",allocationSize = 1)
public class Rota {

	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rota")	
	private Integer codigo;

	@Column(name="descricao")
	private String descricao;
	
	@Column(name="data_inicio")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dataInicio;
	
	@Column(name="data_fim")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dataFinal;
	
	
}
