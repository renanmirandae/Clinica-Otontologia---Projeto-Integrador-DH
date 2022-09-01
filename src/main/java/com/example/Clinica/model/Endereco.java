package com.example.Clinica.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Endereco {
    private int id, idPaciente;
    private String logradouro, endereco, numero, cidade, estado, cep;
}
