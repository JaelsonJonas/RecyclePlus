package br.com.recycleplus.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.recycleplus.DTO.TransactionData;
import br.com.recycleplus.models.Transacao;
import br.com.recycleplus.repository.TransacaoRepository;

@RestController
@RequestMapping("/transactions")
public class TransacaoController {

    @Autowired
    TransacaoRepository repository;

    @PostMapping
    public ResponseEntity<Transacao> save(@RequestBody Transacao novaTransacao) {

        repository.save(novaTransacao);

        return ResponseEntity.ok().body(novaTransacao);
    }

    @GetMapping
    public Page<TransactionData> index(@RequestParam(required = false) String status,
            @PageableDefault(size = 3) Pageable pageable) {

        if (status == null)
            return repository.findAll().stream()
                    .map(t -> new TransactionData(t))
                    .collect(Collectors.collectingAndThen(Collectors.toList(), lista -> new PageImpl<>(lista,
                            PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()), lista.size())));

        return repository.findByTipoContaining(status, pageable).stream()
                .map(t -> new TransactionData(t))
                .collect(Collectors.collectingAndThen(Collectors.toList(), lista -> new PageImpl<>(lista,
                        PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()), lista.size())));
    }

}
