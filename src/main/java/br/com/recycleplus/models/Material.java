package br.com.recycleplus.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Material {
    
    private Long id;
    private String nome;
    private BigDecimal valor;
    private Tipo tipo;
    
}
