package br.com.recycleplus.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "T_RCB_ENDERECO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_ENDERECO")
    private Integer id;

    @NotBlank(message = "Informe um logradouro valido")
    @Size(max = 50)
    @Column(name = "NM_LOGRADOURO", nullable = false, length = 50)
    private String logradouro;

    @NotNull(message = "Informe um numero valido")
    @Max(value = 99999, message = "O número deve ter no máximo 5 dígitos")
    @Column(name = "NR_LOGRADOURO", nullable = false, length = 5)
    private Integer numero;

    @NotBlank(message = "Informe um CEP valido")
    @Size(max = 8)
    @Column(name = "DS_CEP", nullable = false, length = 8)
    private String cep;

    @NotBlank(message = "Informe um Bairro valido")
    @Size(max = 20)
    @Column(name = "NM_BAIRRO", nullable = false, length = 20)
    private String bairro;

    @NotBlank(message = "Informe uma Cidade valido")
    @Size(max = 20)
    @Column(name = "NM_CIDADE", nullable = false, length = 20)
    private String cidade;

    @NotBlank(message = "Informe uma Estado valido")
    @Size(max = 20)
    @Column(name = "NM_ESTADO", nullable = false, length = 20)
    private String estado;

    @Enumerated(value = EnumType.STRING)
    @NotNull(message = "Defina o estado valido")
    @Column(name = "SG_ESTADO", nullable = false)
    private Sigla sigla;

    @Enumerated(value = EnumType.STRING)
    @NotNull(message = "Status vazio ou invalido")
    @Column(name = "ST_ENDERECO",nullable = false)
    private Status status;

    @NotNull(message = "Transação necessita de um Usuario")
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
