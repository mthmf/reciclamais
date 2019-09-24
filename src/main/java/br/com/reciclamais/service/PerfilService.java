package br.com.reciclamais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.reciclamais.model.Lixeira;
import br.com.reciclamais.model.Perfil;
import br.com.reciclamais.repository.LixeiraRepository;
import br.com.reciclamais.repository.PerfilRepository;

@Component
public class PerfilService implements IPerfilService {

	@Autowired
	private PerfilRepository repository;
	
		@Override
	public List<Perfil> getAllRota() {
		return (List<Perfil>) repository.findAll();
	}

	@Override
	public Perfil getPerfilById(Integer codigo) {
		Optional<Perfil> perfil = repository.findById(codigo);
		if(perfil.isPresent()) {
			return perfil.get();		
		}
		return null;
	}

	@Override
	public boolean adicionaPerfil(Perfil perfil) {
		return repository.save(perfil) != null;

	}

	@Override
	public void alteraPerfil(Perfil perfil) {
		repository.save(perfil);

		
	}

	@Override
	public void deletaPerfil(Perfil perfil) {
		repository.delete(perfil);
		
	}
	
	

}
