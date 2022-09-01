package com.example.Clinica.entity;

public class DentistaEntity extends PessoaEntity {
    public DentistaEntity(int id, String nome, String sobrenome, String documento, String senha, String tipo) {
        super(id, nome, sobrenome, documento, senha, tipo);
    }

    public DentistaEntity(String nome, String sobrenome, String documento, String senha, String tipo) {
        super(nome, sobrenome, documento, senha, tipo);
    }
}
