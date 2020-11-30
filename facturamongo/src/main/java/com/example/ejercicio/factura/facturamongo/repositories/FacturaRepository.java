package com.example.ejercicio.factura.facturamongo.repositories;

import com.example.ejercicio.entidadesMongo.Facturas;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FacturaRepository extends MongoRepository<Facturas, String> {

    List<Facturas> findByEstado(String estado);

    List<Facturas> findByTotal(double total);

    List<Facturas> findByIdcliente(Integer id);
}
