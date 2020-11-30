package com.bootcamp.ejercicio.visitasql.repositories;

import com.bootcamp.ejercicio.entidadesMySQL.domain.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitaRepository  extends JpaRepository<Visita, Integer> {
    List<Visita> findByCliente(int id);

    List<Visita> findByEstados(String estados);

}
