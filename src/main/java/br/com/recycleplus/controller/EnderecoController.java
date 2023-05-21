package br.com.recycleplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.recycleplus.exceptions.RestNotFoundException;
import br.com.recycleplus.models.Endereco;
import br.com.recycleplus.repository.EnderecoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/adress")
public class EnderecoController {

    @Autowired
    EnderecoRepository repository;

    @PostMapping
    public ResponseEntity<Endereco> save(@RequestBody @Valid Endereco novo) {

        return ResponseEntity.ok().body(repository.save(novo));
    }

    @PutMapping("{id}")
    public ResponseEntity<Endereco> updatebyIdUsuario(@PathVariable Long idUsuario, @RequestBody @Valid Endereco novo) {

        Endereco update = getByIdUsuario(idUsuario);

        novo.setId(update.getId());
        novo.setIdUsuario(update.getIdUsuario());

        repository.save(new Endereco(novo));

        return ResponseEntity.ok().body(novo);
    }

    private Endereco getByIdUsuario(Long idUsuario) {
        return repository.findByIdUsuario(idUsuario)
                .orElseThrow(() -> new RestNotFoundException("Usuario nao encontrado"));
    }
}
