package br.com.reciclamais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.reciclamais.model.Usuario;
import br.com.reciclamais.repository.UsuarioRepository;

@Component
public class UsuarioService implements IUsuarioService{

	@Autowired
	protected UsuarioRepository repository;
	
	@Override
	public List<Usuario> getAllUsuario() {
		return (List<Usuario>) repository.findAll();
	}

	@Override
	public Usuario getUsuarioById(Integer codigo) {
		Optional<Usuario> usuario = repository.findById(codigo);
		if(usuario.isPresent()) {
			return usuario.get();		
		}
		return null;
	}

	@Override
	public boolean adicionaUsuario(Usuario usuario) {
		// Valida existencia do cpf ou email do usuario a ser cadastrado
		if(getUsuarioByCpfOrEmail(usuario.getCpf(), usuario.getEmail()) != null) {
			return false;
		}
		return repository.save(usuario) != null;
	}

	@Override
	public void alteraUsuario(Usuario usuario) {
		repository.save(usuario);
	}

	@Override
	public void deletaUsuario(Usuario usuario) {
		repository.delete(usuario);
	}

	@Override
	public Usuario getUsuarioByCpfOrEmail(String cpf, String email) {
		return repository.findByCpfOrEmail(cpf,email);
	}

	@Override
	public Usuario getUsuarioByLogin(String email, String senha) {
		return repository.findByEmailAndSenha(email, senha);
	}

	
	
}
