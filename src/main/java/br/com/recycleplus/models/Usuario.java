package br.com.recycleplus.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
}
