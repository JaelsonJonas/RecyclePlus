package br.com.recycleplus.DTO;

import br.com.recycleplus.models.Endereco;

public record Adress(String logradouro, Integer numero, String cep, String bairro, String cidade, String estado,
        String sigla) {

    public Adress(Endereco e) {
        this(e.getLogradouro(), e.getNumero(), e.getCep(), e.getBairro(), e.getCidade(), e.getEstado(), e.getSigla());
    }

}
