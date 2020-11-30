package com.example.ejercicio.pago.PagoMongo.repositories;

import com.example.ejercicio.entidadesMongo.Pagos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoMongoRepository extends MongoRepository<Pagos, String> {
    List<Pagos> findByIdfactura(String id);

    List<Pagos> findByEstado(String estado);
}
