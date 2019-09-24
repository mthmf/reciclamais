package br.com.reciclamais.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.reciclamais.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	List<Usuario> findByNome(String nome);
	
	List<Usuario> findByEmail(String email);
}