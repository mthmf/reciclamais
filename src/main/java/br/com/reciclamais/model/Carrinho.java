package br.com.reciclamais.model;

import java.math.BigDecimal;
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
@Entity(name="carrinho_lixo")
@SequenceGenerator(name = "seq_carrinho",sequenceName = "seq_carrinho",allocationSize = 1)
public class Carrinho {
	
	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carrinho")	
	private Integer codigo;
	
	@Column(name="codigo_usuario")
	private Integer usuario;
	
	@Column(name="data_criacao")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dataCriacao;
	
	@Column(name="total_peso")
	private BigDecimal totalPesoReciclavel;
	
	@Column(name="ativo")
	private Boolean ativo;

}
