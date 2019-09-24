package br.com.reciclamais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.reciclamais.model.BaixaCarrinho;
import br.com.reciclamais.model.BaixaRota;
import br.com.reciclamais.repository.BaixaRotaRepository;

@Component
public class BaixaRotaService implements IBaixaRotaService {

	@Autowired
	private BaixaRotaRepository repository;

	@Override
	public List<BaixaRota> getAllBaixaRota() {
		return (List<BaixaRota>) repository.findAll();
	}

	@Override
	public BaixaRota getBaixaRotaById(Integer codigo) {
		Optional<BaixaRota> baixa = repository.findById(codigo);
		if(baixa.isPresent()) {
			return baixa.get();		
		}
		return null;
	}

	@Override
	public boolean adicionaBaixaRota(BaixaRota baixaRota) {
		return repository.save(baixaRota) != null;
	}

	@Override
	public void alteraBaixaRota(BaixaRota baixaRota) {
		repository.save(baixaRota);
	
	}

	@Override
	public void deletaBaixaRota(BaixaRota baixaRota) {
		repository.delete(baixaRota);		
		
	}
	
}
