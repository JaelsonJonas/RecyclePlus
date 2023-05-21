package br.com.recycleplus.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import br.com.recycleplus.models.Transacao;

public record TransactionData(Long id, LocalDate data, BigDecimal valor, LocalTime horario, String tipo) {

    public TransactionData(Transacao t) {
        this(t.getId(), t.getData(), t.getValor(), t.getHorario(), t.getTipo());
    }

}
