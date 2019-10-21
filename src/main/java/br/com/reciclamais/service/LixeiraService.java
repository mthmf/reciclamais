package br.com.reciclamais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.reciclamais.model.Lixeira;
import br.com.reciclamais.repository.LixeiraRepository;

@Component
public class LixeiraService implements ILixeiraService {

	@Autowired
	private LixeiraRepository repository;
	
	@Override
	public List<Lixeira> getAllLixeiras() {
		return (List<Lixeira>) repository.findAll();
	}

	@Override
	public Lixeira getLixeiraById(Integer codigo) {
		Optional<Lixeira> lixeira = repository.findById(codigo);
		if(lixeira.isPresent()) {
			return lixeira.get();		
		}
		return null;
	}

	@Override
	public boolean adicionaLixeira(Lixeira lixeira) {
		return repository.save(lixeira) != null;

	}

	@Override
	public void alteraLixeira(Lixeira lixeira) {
		repository.save(lixeira);
		
	}

	@Override
	public void deletaLixeira(Lixeira lixeira) {
		repository.delete(lixeira);
		
	}

	@Override
	public List<Lixeira> getLixeirasDaRota(Integer codigoRota) {
		return getLixeirasDaRota(codigoRota);
	}

}
