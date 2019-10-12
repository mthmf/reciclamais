package br.com.reciclamais.service;

import java.util.List;

import br.com.reciclamais.model.Usuario;

public interface IUsuarioService {

	List<Usuario> getAllUsuario();
	
	Usuario getUsuarioByLogin(String email, String senha);

	Usuario getUsuarioById(Integer usuario);
	
	Usuario getUsuarioByCpfOrEmail(String cpf, String email);
    
	boolean adicionaUsuario(Usuario usuario);
    
	void alteraUsuario(Usuario usuario);
    
	void deletaUsuario(Usuario usuario);
}
