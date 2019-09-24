package br.com.reciclamais.model;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
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
@Entity(name="produto")
@SequenceGenerator(name = "seq_produto",sequenceName = "seq_produto",allocationSize = 1)
public class Produto {

	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")	
	private Integer codigo;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="nome_fabricante")
	private String nomeFabricante;
	
	@Column(name="peso")
	private BigDecimal peso;
	
	@Column(name="data_validade", columnDefinition = "TIMESTAMP WITH TIME ZONE")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dataValidade;
}
