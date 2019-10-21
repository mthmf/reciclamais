package br.com.reciclamais.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.reciclamais.model.Lixeira;

public interface LixeiraRepository extends CrudRepository<Lixeira, Integer>  {

	List<Lixeira> findByCodigoRota(Integer codigoRota);
	
}
