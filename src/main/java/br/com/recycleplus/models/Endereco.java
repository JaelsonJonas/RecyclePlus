package br.com.recycleplus.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String logradouro;
    private Integer numero;
    private Integer cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String sigla;

    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Integer idUsuario;

    public Endereco(Endereco e) {
        this.logradouro = e.getLogradouro();
        this.numero = e.getNumero();
        this.cep = e.getCep();
        this.bairro = e.getBairro();
        this.cidade = e.getCidade();
        this.estado = e.getEstado();
        this.sigla = e.getSigla();
    }
}
