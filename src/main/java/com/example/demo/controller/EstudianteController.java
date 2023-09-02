package com.example.demo.controller;

import com.example.demo.dto.EstudianteDTO;
import com.example.demo.service.port.EstudianteService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public EstudianteDTO registrarEstudiante(@RequestBody EstudianteDTO estudianteDTO){
        return estudianteService.save(estudianteDTO);
    }

    @GetMapping
    public List<EstudianteDTO> listarEstudiantes(){
        return estudianteService.findAll();
    }

    @GetMapping("/{id}")
    public EstudianteDTO obtenerEstudiante(@PathParam("id") Long id){
        return estudianteService.find(id);
    }

    @PutMapping("/{id}")
    public EstudianteDTO actualizarEstudiante(@RequestBody EstudianteDTO estudianteDTO, @PathParam("id") Long id){
        return estudianteService.update(estudianteDTO, id);
    }

    @DeleteMapping("{id}")
    public void eliminarEstudiante(@PathParam("id") Long id){
        estudianteService.delete(id);
    }

}
