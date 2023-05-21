package br.com.recycleplus.DTO;

import jakarta.validation.constraints.NotBlank;

public record Credendial(
    @NotBlank String email, 
    @NotBlank String senha) {

}
