package br.com.recycleplus.DTO;

import jakarta.validation.constraints.NotBlank;

public record ResetSenha(
        @NotBlank(message = "campo não deve ser vazio") String senha) {

}
