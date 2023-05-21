package br.com.recycleplus.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.recycleplus.models.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    Page<Transacao> findByTipoContaining(String descricao, Pageable pageable);

    Page<Transacao> findByIdUsuario(Long id, Pageable pageable);

}
