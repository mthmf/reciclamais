package br.com.reciclamais.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	private Integer codigo;
	private String nome;
	private String email;
	private String senha;
	private String tipo;
	private String cpf;
}
