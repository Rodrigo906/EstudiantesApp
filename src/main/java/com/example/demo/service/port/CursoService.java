package com.example.demo.service.port;

import com.example.demo.dto.CursoDTO;
import jakarta.validation.constraints.NotNull;

public interface CursoService {

    void registrarCurso(@NotNull CursoDTO cursoDTO);
}
