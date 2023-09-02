package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EstudianteDTO {
    private int dni;
    private String email;
    private LocalDate fechaDeNacimiento;
    private String nombre;
    private String apellido;
    private int edad;
}
