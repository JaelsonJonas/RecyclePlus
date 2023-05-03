package br.com.recycleplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recycleplus.models.Material;

public interface MaterialRepository extends JpaRepository<Material,Long> {
    
}
