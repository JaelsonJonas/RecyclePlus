package br.com.recycleplus.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
    public ResponseEntity<Object> register(@RequestBody @Valid Usuario usuarioNovo) {

        ExampleMatcher em = ExampleMatcher.matching().withMatcher("DS_LOGIN",
                usuario -> usuario.exact());
        Example<Usuario> criterioDeBusca = Example.of(new Usuario(usuarioNovo.getEmail().toLowerCase()), em);

        Optional<Usuario> optUsr = repository.findOne(criterioDeBusca);

        if (optUsr.isPresent()) {
            return ResponseEntity.badRequest()
                    .body(new ReturnAPI("Desculpe, login já em uso. Por favor, tente outro."));
        }

        repository.save(usuarioNovo);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioNovo);
    }

    @PostMapping("/login")
    public ResponseEntity<ReturnAPI> login(@RequestBody Credendial credencial) {

        Optional<Usuario> usuarioConteiner = repository.findByEmailAndSenha(credencial.email(), credencial.senha());

        if (usuarioConteiner.isPresent()) {
            return ResponseEntity.ok().body(new ReturnAPI("Login realizado com sucesso!!"));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ReturnAPI("usuario/senha invalido"));

    }

    @GetMapping("/all/{id}")
    public ResponseEntity<UsuarioDTO> getbyId(@PathVariable Long id, @PageableDefault(size = 2) Pageable pageable) {

        return ResponseEntity.ok(getUsuarioDTO(id, pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> getbyId(@PathVariable Long id) {

        return ResponseEntity.ok(getUsuario(id));
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

    private UsuarioDTO getUsuarioDTO(Long id, Pageable pageable) {
        return service.getWithEndereco(id, pageable);
    }
}
