package com.example.demo.controller;

import com.example.demo.service.port.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping("/{idEstudiante}/{idCurso}")
    public void registrarInscripcion(@PathVariable Long idEstudiante, @PathVariable Long idCurso){
        inscripcionService.registrarInscripcion(idEstudiante, idCurso);
    }
}
