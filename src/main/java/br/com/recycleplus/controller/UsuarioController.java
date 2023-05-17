package br.com.recycleplus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.recycleplus.DTO.Credendial;
import br.com.recycleplus.exceptions.RestNotFoundException;
import br.com.recycleplus.models.Usuario;
import br.com.recycleplus.repository.UsuarioRepository;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Credendial credencial) {

        return ResponseEntity.ok().body(repository.save(new Usuario(credencial.email(), credencial.senha())));

    }

    @GetMapping("/user")
    public List<Credendial> getAllLogin() {

        return repository.findAll().stream().map(u -> new Credendial(u.getId(), u.getEmail(), u.getSenha())).toList();
    }

    @PostMapping("/user")
    public ResponseEntity<Usuario> register(@RequestBody Credendial credencial) {
        Usuario novo = new Usuario(credencial.email(), credencial.senha());

        return ResponseEntity.ok().body(repository.save(novo));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario update) {
        Usuario usuarioUpdate = getUsuario(id);

        update.setId(usuarioUpdate.getId());

        return ResponseEntity.ok(repository.save(update));
    }

    private Usuario getUsuario(Long id) {

        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuario nao encontrado"));

    }
}
