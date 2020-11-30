package com.example.ejercicio.factura.facturamongo.repositories;

import com.example.ejercicio.entidadesMongo.Facturas;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface FacturaAsincronoRepository extends ReactiveMongoRepository<Facturas, String> {

    Mono<Void> deleteById(String id);
}
