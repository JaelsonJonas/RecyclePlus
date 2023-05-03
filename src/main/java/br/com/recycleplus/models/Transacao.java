package br.com.recycleplus.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transacao {

    private Long id;
    private LocalDate data;
    private BigDecimal valor;
    private String envioadoRecebido;
    private LocalTime horario;

}
