package com.example.demo.controller;

import com.example.demo.service.port.InscripcionService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping("/{idEstudiante}/{idCurso}")
    public void registrarInscripcion(@PathParam("idEstudiante") Long idEstudiante,
                                               @PathParam("idCurso") Long idCurso){
        inscripcionService.registrarInscripcion(idEstudiante, idCurso);
    }
}
