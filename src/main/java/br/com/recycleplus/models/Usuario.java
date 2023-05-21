package br.com.recycleplus.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Login ou senha invalidos")
    @Size(max = 50)
    private String login;

    @NotBlank(message = "Login ou senha invalidos")
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank(message = "Login ou senha invalidos")
    @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres")
    private String senha;

    @NotBlank(message = "Digite um nome valido")
    private String nomeCompleto;

    @NotBlank(message = "Documento vazio ou invalido")
    private String documento;

    @NotBlank(message = "Telefone vazio ou invalido")
    private String telefone;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNasc;

    @NotBlank(message = "Genero vazio ou invalido")
    private String genero;

    private String foto;

    @OneToMany(mappedBy = "idUsuario", cascade = CascadeType.PERSIST)
    private List<Transacao> transactions;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
}
