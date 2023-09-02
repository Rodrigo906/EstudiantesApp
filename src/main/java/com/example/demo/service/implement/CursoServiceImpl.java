package com.example.demo.service.implement;

import com.example.demo.domain.Curso;
import com.example.demo.dto.CursoDTO;
import com.example.demo.repository.CursoRepository;
import com.example.demo.service.port.CursoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Transactional
@Validated
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;


    @Override
    public void registrarCurso(CursoDTO cursoDTO) {
        Curso curso = new Curso(null, cursoDTO.getNombre(), cursoDTO.getDescripcion(), cursoDTO.getFechaDeInicio(),
                cursoDTO.getFechaDeFin());

        cursoRepository.save(curso);
    }
}
