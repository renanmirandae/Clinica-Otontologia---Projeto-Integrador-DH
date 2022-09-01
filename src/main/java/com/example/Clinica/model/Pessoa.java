package com.example.Clinica.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Pessoa {
    private int id;
    private String nome, sobrenome, documento, senha, tipo;
}
