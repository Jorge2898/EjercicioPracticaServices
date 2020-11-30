package com.bootcamp.ejercicio.cliente.repositories;

import com.bootcamp.ejercicio.entidadesMySQL.domain.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Integer> {

    List<Direccion> findByIdcliente(int clientid);

    List<Direccion> findByPoblacion(String poblacion);
}
