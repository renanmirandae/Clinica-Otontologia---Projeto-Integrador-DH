package com.example.Clinica.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DentistaEntity extends PessoaEntity {
    public DentistaEntity(int id, String nome, String sobrenome, String documento, String senha, String tipo) {
        super(id, nome, sobrenome, documento, senha, tipo);
    }

    public DentistaEntity(@JsonProperty("nome") String nome, @JsonProperty("sobrenome") String sobrenome, @JsonProperty("documento") String documento, @JsonProperty("senha") String senha,@JsonProperty("tipo") String tipo) {
        super(nome, sobrenome, documento, senha, tipo);
    }
}
