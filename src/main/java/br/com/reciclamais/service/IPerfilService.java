package br.com.reciclamais.service;

import java.util.List;

import br.com.reciclamais.model.Perfil;

public interface IPerfilService {
	
	List<Perfil> getAllRota();

	Perfil getPerfilById(Integer codigo);
    
	boolean adicionaPerfil(Perfil perfil);
    
	void alteraPerfil(Perfil perfil);
    
	void deletaPerfil(Perfil perfil);

}
