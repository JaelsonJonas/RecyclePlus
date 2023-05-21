package br.com.recycleplus.DTO;

import java.math.BigDecimal;

import br.com.recycleplus.models.Material;
import br.com.recycleplus.models.Tipo;

public record MaterialDTO(String nome, BigDecimal valor, Tipo tipo) {

    public MaterialDTO(Material m) {
        this(m.getNome(), m.getValor(), m.getTipo());
    }

}
