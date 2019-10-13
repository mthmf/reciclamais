package br.com.reciclamais.service;

import java.util.List;

import br.com.reciclamais.model.Lixeira;

public interface ILixeiraService {

	List<Lixeira> getAllLixeiras();
	
	List<Lixeira> getLixeirasDaRota(Integer idRota);

	Lixeira getLixeiraById(Integer codigo);
    
	boolean adicionaLixeira(Lixeira lixeira);
    
	void alteraLixeira(Lixeira lixeira);
    
	void deletaLixeira(Lixeira lixeira);
	
	
	
}
