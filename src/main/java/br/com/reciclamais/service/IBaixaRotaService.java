package br.com.reciclamais.service;

import java.util.List;

import br.com.reciclamais.model.BaixaRota;

public interface IBaixaRotaService {
	
	List<BaixaRota> getAllBaixaRota();

	BaixaRota getBaixaRotaById(Integer codigo);
    
	boolean adicionaBaixaRota(BaixaRota baixaRota);
    
	void alteraBaixaRota(BaixaRota baixaRota);
    
	void deletaBaixaRota(BaixaRota baixaRota);
	
}
