package br.com.recycleplus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recycleplus.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByEmailAndSenha(String email, String senha);
    
}
