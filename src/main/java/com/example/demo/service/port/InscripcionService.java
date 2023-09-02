package com.example.demo.service.port;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

@Validated
public interface InscripcionService {

    void registrarInscripcion(@NotNull @Positive Long idEstudiante, @NotNull @Positive Long idCurso);
}
