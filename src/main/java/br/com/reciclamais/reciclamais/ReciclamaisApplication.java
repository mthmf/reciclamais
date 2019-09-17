package br.com.reciclamais.reciclamais;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.reciclamais.model.Usuario;
import br.com.reciclamais.repository.UsuarioRepository;
import br.com.reciclamais.repository.UsuarioRepository;

@SpringBootApplication()

@EntityScan("br.com.reciclamais.model")
@EnableConfigurationProperties()
@EnableJpaRepositories(basePackages="br.com.reciclamais.repository")
public class ReciclamaisApplication {
	
	@Autowired
	public UsuarioRepository repo;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ReciclamaisApplication.class);
		
		Usuario usuario = new Usuario();
		usuario.setCpf("0352148445");
		usuario.setEmail("teste1@teste1.com");
		usuario.setNome("Lucas");
		usuario.setSenha("1234");
		usuario.setTipo("C");
		
		UsuarioRepository repo = context.getBean(UsuarioRepository.class);
		//repo.save(usuario);
				
		Usuario s = repo.findByEmail("teste1@teste1.com").get(0);
		System.out.println(s.getNome());
		
	}

}
