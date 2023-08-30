package com.example.demo;

import com.example.demo.domain.Curso;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Estudiante;
import com.example.demo.domain.Inscripcion;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.InscripcionRepository;
import com.example.demo.service.port.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private EstudianteRepository estudianteRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private InscripcionRepository inscripcionRepository;

	@Autowired
	private InscripcionService inscripcionService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return args -> {
			Estudiante estudiante1 = new Estudiante(null, 41478211, "rodrigo@gmail.com",
					LocalDate.of(1999, 7, 11), "Rodrigo", "Calizaya", 24);
			Estudiante estudiante2 = new Estudiante(null, 45467211, "lucas@gmail.com",
					LocalDate.of(2002, 5, 12), "Lucas", "Romero", 21);
			Estudiante estudiante3 = new Estudiante(null, 45832211, "pedro@gmail.com",
					LocalDate.of(2002, 5, 12), "Pedro", "Lopez", 25);
			Estudiante estudiante4 = new Estudiante(null, 46366212, "lucia@gmail.com",
					LocalDate.of(2002, 5, 12), "Lucia", "Rodriguez", 27);
			Estudiante estudiante5 = new Estudiante(null, 48468413, "maria@gmail.com",
					LocalDate.of(2002, 5, 12), "Maria", "Suarez", 30);
			Estudiante estudiante6 = new Estudiante(null, 40437219, "Luis@gmail.com",
					LocalDate.of(2002, 5, 12), "Luis", "Romero", 35);

			estudiante1 = estudianteRepository.saveAndFlush(estudiante1);
			estudiante2 = estudianteRepository.saveAndFlush(estudiante2);
			estudianteRepository.save(estudiante3);
			estudianteRepository.save(estudiante4);
			estudianteRepository.save(estudiante5);
			estudianteRepository.save(estudiante6);

			Curso curso = new Curso(null, "Desarrollo backend", "",
					LocalDate.of(2020, 3, 1), LocalDate.of(2020, 6, 30));
			curso = cursoRepository.saveAndFlush(curso);

			Inscripcion inscripcion = new Inscripcion(null, curso, Estado.ACEPTADA,
					LocalDate.of(2023,7, 2), estudiante1);
			Inscripcion inscripcion2 = new Inscripcion(null, curso, Estado.PENDIENTE,
					LocalDate.of(2023,7, 3), estudiante2);

			inscripcionRepository.save(inscripcion);
			inscripcionRepository.save(inscripcion2);

			//Consultas
            cursoRepository.findAll();
			estudianteRepository.findAll();
			estudianteRepository.findByDniGreaterThanAndApellido(20000000, "Romero");
			inscripcionRepository.findByEstadoIn(List.of(Estado.RECHAZADA, Estado.PENDIENTE));
			cursoRepository.cursosIniciadosDespuesDe(LocalDate.of(2020, 2, 1));
			inscripcionRepository.listarPorEstadoJpql(Estado.ACEPTADA);
			inscripcionRepository.listarPorEstadoNativa(Estado.PENDIENTE.name());
			estudianteRepository.findByOrderByDniAsc(PageRequest.of(1, 5));
			estudianteRepository.findByOrderByDniAsc(PageRequest.of(0, 2));

			inscripcionService.registrarInscripcion(1L, 1L);
		};
	}
}
