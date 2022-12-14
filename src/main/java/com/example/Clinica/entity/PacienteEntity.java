package com.example.Clinica.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PacienteEntity extends PessoaEntity {
    private LocalDate dataAlta;

    public PacienteEntity(int id, String nome, String sobrenome, String documento, String senha, String tipo, LocalDate dataAlta) {
        super(id, nome, sobrenome, documento, senha, tipo);
        this.dataAlta = dataAlta;
    }
}
