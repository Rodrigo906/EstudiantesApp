package com.example.demo.repository;

import com.example.demo.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findAll();

    @Query("SELECT c FROM Curso c WHERE c.fechaDeInicio > :fecha")
    List<Curso> cursosIniciadosDespuesDe(@Param("fecha") LocalDate fecha);
}
