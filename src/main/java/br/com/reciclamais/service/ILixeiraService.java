package br.com.reciclamais.service;

import java.util.List;

import br.com.reciclamais.model.Lixeira;

public interface ILixeiraService {

	List<Lixeira> getAllLixeira();

	Lixeira getLixeiraById(Integer codigo);
    
	boolean adicionaLixeira(Lixeira lixeira);
    
	void alteraLixeira(Lixeira lixeira);
    
	void deletaLixeira(Lixeira lixeira);
	
}
