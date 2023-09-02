package com.example.demo.service.port;

import com.example.demo.dto.EstudianteDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public interface EstudianteService {

    EstudianteDTO save(@NotNull EstudianteDTO estudianteDTO);

    List<EstudianteDTO> findAll();

    EstudianteDTO find(@NotNull @Positive Long id);

    EstudianteDTO update(@NotNull EstudianteDTO estudianteDTO, @NotNull @Positive Long id);

    void delete(@NotNull @Positive Long id);
}
