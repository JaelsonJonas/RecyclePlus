package br.com.recycleplus.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "T_RCB_USUARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_USUARIO")
    private Long id;

    @NotBlank(message = "Login ou senha invalidos")
    @Size(max = 50)
    @Column(name = "DS_LOGIN", nullable = false, length = 50)
    private String login;

    @NotBlank(message = "Login ou senha invalidos")
    @Size(max = 50)
    @Email
    @Column(name = "DS_EMAIL", nullable = false, length = 50)
    private String email;

    @NotBlank(message = "Login ou senha invalidos")
    @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres")
    @Column(name = "DS_SENHA", nullable = false, length = 20)
    private String senha;

    @NotBlank(message = "Digite um nome valido")
    @Size(max = 50)
    @Column(name = "NM_NOME", nullable = false, length = 50)
    private String nomeCompleto;

    @NotBlank(message = "Documento vazio ou invalido")
    @Size(max = 14)
    @Column(name = "NM_DOCUMENTO", nullable = false, length = 14)
    private String documento;

    @NotBlank(message = "Telefone vazio ou invalido")
    @Column(name = "DS_TELEFONE", nullable = false, length = 13)
    @Size(max = 13)
    private String telefone;

    @NotNull(message = "A data deve ser no formato yyyy-MM-dd ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DT_NASCIMENTO", nullable = false)
    private LocalDate dataNasc;

    @Enumerated(value = EnumType.STRING)
    @NotNull(message = "Genero vazio ou invalido")
    @Column(name = "DS_GENERO",nullable = false)
    private Genero genero;

    @Column(name = "DS_FOTO")
    private String foto;

    @Enumerated(value = EnumType.STRING)
    @NotNull(message = "Status vazio ou invalido")
    @Column(name = "ST_USUARIO",nullable = false)
    private Status status;

    @OneToMany(mappedBy = "idUsuario", cascade = CascadeType.ALL)
    private List<Transacao> transactions;

    public Usuario(String email) {
        this.email = email;
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    
}
