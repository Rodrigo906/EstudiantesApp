package com.example.demo.service.implement;

import com.example.demo.domain.Curso;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Estudiante;
import com.example.demo.domain.Inscripcion;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.InscripcionRepository;
import com.example.demo.service.port.InscripcionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;


@Service
@Transactional
public class InscripcionServiceImpl implements InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void registrarInscripcion(Long idEstudiante, Long idCurso) {
        Estudiante estudiante = estudianteRepository
                .findById(idEstudiante)
                .orElseThrow(() -> new RuntimeException("El id del estudiante no es valido"));

        if(!estudiante.esMayorDeEdad())
            throw new RuntimeException("El estudiante es menor de edad");

        Curso curso = cursoRepository
                .findById(idCurso)
                .orElseThrow(() -> new RuntimeException("El id del curso no es valido"));

        Inscripcion inscripcion = new Inscripcion(null, curso, Estado.ACEPTADA, LocalDate.now(), estudiante);
        inscripcionRepository.save(inscripcion);
    }
}
