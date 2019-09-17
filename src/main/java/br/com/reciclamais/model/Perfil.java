package br.com.reciclamais.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="perfil")
@SequenceGenerator(name = "seq_perfil",sequenceName = "seq_perfil",allocationSize = 1)
public class Perfil {
	
	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_perfil")	
	private Integer codigo;

	@Column(name="nome")
	private String nome;
	
}
