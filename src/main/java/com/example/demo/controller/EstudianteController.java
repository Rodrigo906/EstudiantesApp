package com.example.demo.controller;

import com.example.demo.dto.EstudianteDTO;
import com.example.demo.service.port.EstudianteService;
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
    public EstudianteDTO obtenerEstudiante(@PathVariable Long id){
        return estudianteService.find(id);
    }

    @PutMapping("/{id}")
    public EstudianteDTO actualizarEstudiante(@RequestBody EstudianteDTO estudianteDTO, @PathVariable Long id){
        return estudianteService.update(estudianteDTO, id);
    }

    @DeleteMapping("{id}")
    public void eliminarEstudiante(@PathVariable Long id){
        estudianteService.delete(id);
    }

}
