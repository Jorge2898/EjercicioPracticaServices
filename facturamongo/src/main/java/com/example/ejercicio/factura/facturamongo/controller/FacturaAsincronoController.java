package com.example.ejercicio.factura.facturamongo.controller;

import com.example.ejercicio.entidadesMongo.Facturas;
import com.example.ejercicio.factura.facturamongo.repositories.FacturaAsincronoRepository;
import com.example.ejercicio.factura.facturamongo.services.FacturaAsincronoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FacturaAsincronoController {

    @Autowired
    FacturaAsincronoService facturaAsincronoService;

    //MOSTRAR UNA FACTURA
    @GetMapping("api/facturaAsin/{id}")
    public Mono<Facturas> getFacturaById(@PathVariable("id") String id){
        return facturaAsincronoService.getFactura(id);
    }

    //MOSTRAR TODAS LAS FACTURAS
    @GetMapping("api/facturaAsin/all")
    public Flux<Facturas> getAllCliente(){
        return facturaAsincronoService.getAllFacturas();
    }

    //INSERTAR UNA FACTURA
    @PostMapping("api/facturaAsin/save")
    public Mono<Facturas> insertFactura(Facturas facturas){
        return facturaAsincronoService.saveFactura(facturas);
    }

    //ELIMINAR UNA FACTURA POR ID
    @DeleteMapping("api/facturaAsin/delete/{id}")
    public void deleteFacturaById(@PathVariable("id") String id){
        Mono<Facturas> facturas = facturaAsincronoService.getFactura(id);
        if(facturas != null){
            facturaAsincronoService.deleteFacturaById(id);
        }else{
            System.out.println("No se encontró ningún registro con ese id");
        }

    }

    //ELIMINAR UNA FACTURA
    @DeleteMapping("/api/facturaAsin/delete")
    public void deleteFactura(@RequestBody Facturas facturas){
        facturaAsincronoService.deleteFactura(facturas);
    }
}
