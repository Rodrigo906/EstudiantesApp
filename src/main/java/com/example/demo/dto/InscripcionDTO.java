package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class InscripcionDTO {
    private Long curso;
    private String estado;
    private LocalDate fechaDeInscripcion;
    private Long estudiante;
}
