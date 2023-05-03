package br.com.recycleplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recycleplus.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
}
