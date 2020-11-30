package com.example.ejercicio.factura.facturamongo.services;

import com.example.ejercicio.entidadesMongo.Facturas;
import com.example.ejercicio.factura.facturamongo.repositories.FacturaAsincronoRepository;
import com.example.ejercicio.factura.facturamongo.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FacturaAsincronoService {

    @Autowired
    FacturaAsincronoRepository facturaAsincronoRepository;

    //MOSTRAR UNA SOLA FACTURA
    public Mono<Facturas> getFactura(String id){
        return facturaAsincronoRepository.findById(id);
    }

    //MOSTRAR TODAS LAS FACTURAS
    public Flux<Facturas> getAllFacturas(){
        return facturaAsincronoRepository.findAll();
    }

    //INSERTAR UNA FACTURA
    public Mono<Facturas> saveFactura(Facturas facturas){
        return facturaAsincronoRepository.insert(facturas);
    }

    //ELIMINAR UNA FACTURA POR ID
    public void deleteFacturaById(String id){
        facturaAsincronoRepository.deleteById(id);
    }

    //ELIMINAR UNA FACTURA
    public void deleteFactura(Facturas facturas){
        facturaAsincronoRepository.delete(facturas);
    }

}
