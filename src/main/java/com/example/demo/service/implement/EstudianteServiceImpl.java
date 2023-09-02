package com.example.demo.service.implement;

import com.example.demo.domain.Estudiante;
import com.example.demo.dto.EstudianteDTO;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.service.port.EstudianteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Transactional
@Validated
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public EstudianteDTO save(EstudianteDTO estudianteDTO){
        Estudiante estudiante = new Estudiante(null, estudianteDTO.getDni(), estudianteDTO.getEmail(),
                estudianteDTO.getFechaDeNacimiento(), estudianteDTO.getNombre(), estudianteDTO.getApellido(),
                estudianteDTO.getEdad());
        estudianteRepository.save(estudiante);
        return estudianteDTO;
    }

    @Override
    public List<EstudianteDTO> findAll(){
        return estudianteRepository.findAll().stream().map(e -> new EstudianteDTO(e.getDni(), e.getEmail(),
                e.getFechaDeNacimiento(), e.getNombre(), e.getApellido(),
                e.getEdad())).toList();
    }

    @Override
    public EstudianteDTO find(Long id) {
        Estudiante e = estudianteRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("El id del estudiante no es valido"));

        return new EstudianteDTO(e.getDni(), e.getEmail(), e.getFechaDeNacimiento(), e.getNombre(),
                e.getApellido(), e.getEdad());
    }

    @Override
    public EstudianteDTO update(EstudianteDTO estudianteDTO, Long id){
        Estudiante estudiante = new Estudiante(id, estudianteDTO.getDni(), estudianteDTO.getEmail(),
                estudianteDTO.getFechaDeNacimiento(), estudianteDTO.getNombre(), estudianteDTO.getApellido(),
                estudianteDTO.getEdad());

        estudianteRepository.save(estudiante);
        return estudianteDTO;
    }

    @Override
    public void delete(Long id){
        estudianteRepository.deleteById(id);
    }

}
