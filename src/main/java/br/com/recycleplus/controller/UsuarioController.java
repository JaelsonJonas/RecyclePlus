package br.com.recycleplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.recycleplus.DTO.Credendial;
import br.com.recycleplus.DTO.ResetSenha;
import br.com.recycleplus.DTO.ReturnAPI;
import br.com.recycleplus.DTO.UsuarioDTO;
import br.com.recycleplus.exceptions.RestNotFoundException;
import br.com.recycleplus.models.Usuario;
import br.com.recycleplus.repository.UsuarioRepository;
import br.com.recycleplus.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario> register(@RequestBody @Valid Usuario newUser) {

        repository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Credendial credencial) {

        return ResponseEntity.ok().body(repository.save(new Usuario(credencial.email(), credencial.senha())));

    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDTO> getbyId(@PathVariable Long id, @PageableDefault(size = 2) Pageable pageable) {

        return ResponseEntity.ok(service.getWithEndereco(id, pageable));
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody @Valid Usuario update) {
        Usuario usuarioUpdate = getUsuario(id);

        update.setId(usuarioUpdate.getId());

        return ResponseEntity.ok(repository.save(update));
    }

    @PutMapping("/password-reset/{id}")
    public ResponseEntity<ReturnAPI> updatePassword(@PathVariable Long id, @RequestBody ResetSenha reset) {

        Usuario resetSenha = getUsuario(id);

        resetSenha.setSenha(reset.senha());

        repository.save(resetSenha);

        return ResponseEntity.ok(new ReturnAPI("Senha alterada com sucesso!"));
    }

    private Usuario getUsuario(Long id) {

        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuario nao encontrado"));

    }
}
