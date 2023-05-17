package br.com.recycleplus.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.recycleplus.models.Usuario;
import br.com.recycleplus.repository.UsuarioRepository;

@Configuration
public class DataSeederConfig implements CommandLineRunner {

    @Autowired
    UsuarioRepository repository;
    
    @Override
    public void run(String... args) throws Exception {
    
        repository.saveAll(List.of(
                new Usuario("jaelson@aocs.com.br", "123432"),
                new Usuario("jow@aocs.com.br", "123432"),
                new Usuario("z@aocs.com.br", "123432")));
    }
    
}
