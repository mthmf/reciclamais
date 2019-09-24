package br.com.reciclamais.service;

import java.util.List;

import br.com.reciclamais.model.Rota;

public interface IRotaService {
	
	List<Rota> getAllRota();

	Rota getRotaById(Integer rota);
    
	boolean adicionaRota(Rota rota);
    
	void alteraRota(Rota rota);
    
	void deletaRota(Rota rota);

}
