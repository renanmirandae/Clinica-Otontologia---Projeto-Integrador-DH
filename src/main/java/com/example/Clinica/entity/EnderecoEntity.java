package com.example.Clinica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EnderecoEntity {
    private int id, idPaciente;
    private String logradouro, endereco, numero, cidade, estado, cep;
}
