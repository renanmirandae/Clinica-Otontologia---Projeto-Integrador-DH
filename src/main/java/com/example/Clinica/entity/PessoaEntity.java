package com.example.Clinica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class PessoaEntity {
    private int id;
    private String nome, sobrenome, documento, senha, tipo;

    public PessoaEntity(String nome, String sobrenome, String documento, String senha, String tipo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.senha = senha;
        this.tipo = tipo;
    }
}
