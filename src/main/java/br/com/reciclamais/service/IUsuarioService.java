package br.com.reciclamais.service;

import java.util.List;

import br.com.reciclamais.model.Usuario;

public interface IUsuarioService {

	List<Usuario> getAllUsuario();

	Usuario getUsuarioById(Integer usuario);
    
	boolean adicionaUsuario(Usuario usuario);
    
	void alteraUsuario(Usuario usuario);
    
	void deletaUsuario(Usuario usuario);
}
