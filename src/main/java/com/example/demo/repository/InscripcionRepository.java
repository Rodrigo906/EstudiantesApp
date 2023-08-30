package com.example.demo.repository;

import com.example.demo.domain.Estado;
import com.example.demo.domain.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    List<Inscripcion> findByEstadoIn(List<Estado> estados);

    @Query("SELECT i FROM Inscripcion i WHERE i.estado = :estado")
    List<Inscripcion> listarPorEstadoJpql(@Param("estado") Estado estado);

    @Query(value = "SELECT * FROM inscripcion i WHERE i.estado = :estado", nativeQuery = true)
    List<Inscripcion> listarPorEstadoNativa(@Param("estado") String estado);
}
