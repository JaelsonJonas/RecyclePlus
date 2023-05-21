package br.com.recycleplus.DTO;

import java.time.LocalDate;
import java.util.List;

import br.com.recycleplus.models.Genero;
import br.com.recycleplus.models.Usuario;

public record UsuarioDTO(
        Long id,
        String login,
        String email,
        String documento,
        String telefone,
        LocalDate dataNasc,
        Genero genero,
        Adress adress,
        List<TransactionData> transactions) {

    public UsuarioDTO(Usuario usuario, List<TransactionData> lista, Adress endereco) {
        this(usuario.getId(), usuario.getLogin(), usuario.getEmail(), usuario.getDocumento(), usuario.getTelefone(),
                usuario.getDataNasc(), usuario.getGenero(),
                endereco, lista);
    }
}
