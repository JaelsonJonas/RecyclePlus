package br.com.recycleplus.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "T_RCB_TRANSACAO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_TRANSACAO")
    private Long id;

    @NotNull(message = "A data deve ser no formato yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DT_TRANSACAO", nullable = false)
    private LocalDate data;

    @NotNull(message = "Insira um valor válido")
    @Column(name = "VT_TRANSACAO", nullable = false)
    private BigDecimal valor;

    @Enumerated(value = EnumType.STRING)
    @NotNull(message = "Defina o status da tranferencia")
    @Column(name = "ST_TRANFERENCIA", nullable = false)
    private StatusTransacao tipo;

    @NotNull(message = "A hora deve ser no formato HH:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "HR_TRANSACAO", nullable = false)
    private LocalTime horario;

    @NotNull(message = "Transação necessita de um Usuario")
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

}
