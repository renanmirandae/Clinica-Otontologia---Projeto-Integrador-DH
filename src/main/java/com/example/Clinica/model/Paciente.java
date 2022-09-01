package com.example.Clinica.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Paciente extends Pessoa{
    private LocalDate dataAlta;

    public Paciente(int id, String nome, String sobrenome, String documento, String senha, String tipo, LocalDate dataAlta) {
        super(id, nome, sobrenome, documento, senha, tipo);
        this.dataAlta = dataAlta;
    }
}
