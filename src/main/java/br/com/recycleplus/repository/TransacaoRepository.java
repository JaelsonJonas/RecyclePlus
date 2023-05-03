package br.com.recycleplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recycleplus.models.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao,Long> {
    
}
