package br.com.reciclamais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.reciclamais.model.Produto;
import br.com.reciclamais.model.Rota;
import br.com.reciclamais.repository.RotaRepository;

@Component
public class RotaService implements IRotaService {
	
	@Autowired
	private RotaRepository repository;

	@Override
	public List<Rota> getAllRota() {
		return (List<Rota>) repository.findAll();	
	}

	@Override
	public Rota getRotaById(Integer codigo) {
		Optional<Rota> rota = repository.findById(codigo);
		if(rota.isPresent()) {
			return rota.get();		
		}
		return null;
	}

	@Override
	public boolean adicionaRota(Rota rota) {
		return repository.save(rota) != null;

	}

	@Override
	public void alteraRota(Rota rota) {
		repository.save(rota);		
	}

	@Override
	public void deletaRota(Rota rota) {
		repository.delete(rota);		
	}
	
	
	
}
