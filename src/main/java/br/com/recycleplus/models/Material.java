package br.com.recycleplus.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "T_RCB_MATERIAL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Material {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_MATERIAL")
    private Long id;

    @NotBlank(message = "Informe um nome valido")
    @Size(max = 50)
    @Column(name = "NM_MATERIAL", nullable = false, length = 50)
    private String nome;

    @NotNull(message = "Informe um valor valido")
    @Min(value = 0 ,message = "Deve ser positivo")
    @Column(name = "VT_MATERIAL", nullable = false, length = 6)
    private BigDecimal valor;

    @Enumerated(value = EnumType.STRING)
    @NotNull(message = "Tipo vazio ou invalido")
    @Column(name = "ST_TIPO",nullable = false)
    private Tipo tipo;
    
}
