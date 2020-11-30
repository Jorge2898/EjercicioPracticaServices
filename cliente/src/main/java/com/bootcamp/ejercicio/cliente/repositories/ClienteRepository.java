package com.bootcamp.ejercicio.cliente.repositories;

import com.bootcamp.ejercicio.entidadesMySQL.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNombre(String name);

    List<Cliente> findByEstado(String estado);
}
