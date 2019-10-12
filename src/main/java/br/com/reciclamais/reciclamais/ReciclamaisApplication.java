package br.com.reciclamais.reciclamais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.reciclamais.repository.UsuarioRepository;

@SpringBootApplication()

@EntityScan("br.com.reciclamais.model")
@EnableConfigurationProperties()
@ComponentScan("br.com.reciclamais")
@EnableJpaRepositories(basePackages="br.com.reciclamais.repository")
public class ReciclamaisApplication {
	
	@Autowired
	public UsuarioRepository repo;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ReciclamaisApplication.class);
	}

}
