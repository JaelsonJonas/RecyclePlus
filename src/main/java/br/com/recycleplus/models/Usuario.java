package br.com.recycleplus.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    private Long id;
    private String login;
    private String email;
    private String senha;
    private String nomeCompleto;
    private String documento;
    private String telefone;
    private LocalDate dataNasc;
    private String genero;
    private String foto;
}
