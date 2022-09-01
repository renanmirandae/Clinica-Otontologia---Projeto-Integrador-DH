package com.example.Clinica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class ConsultaEntity {
    private int id, idDentista, idPaciente;
    private LocalDate data;
    private LocalTime hora;
}
