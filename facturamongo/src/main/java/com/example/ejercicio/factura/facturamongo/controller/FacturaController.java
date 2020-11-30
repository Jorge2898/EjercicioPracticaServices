package com.example.ejercicio.factura.facturamongo.controller;

import com.example.ejercicio.entidadesMongo.Facturas;
import com.example.ejercicio.factura.facturamongo.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FacturaController {

    @Autowired
    FacturaService facturaService;

    //MOSTRAR UNA FACTURA
    @GetMapping("api/factura/{id}")
    public Mono<Facturas> getFacturaById(@PathVariable("id") String id){
        return Mono.just(facturaService.getFactura(id));
    }

    //MOSTRAR TODAS LAS FACTURAS
    @GetMapping("api/factura/all")
    public Flux<Facturas> getFacturaAll(){
        return Flux.fromIterable(facturaService.findAll());
    }

    //INSERTAR UNA FACTURA
    @PostMapping("api/factura/insert")
    public Mono<Facturas> insertFactura(@RequestBody Facturas facturas){
        return Mono.just(facturaService.saveFactura(facturas));
    }

    //ELIMINAR UNA FACTURA
    @DeleteMapping("api/factura/delete/{id}")
    public void deleteFactura(@PathVariable("id") String id){
        Facturas facturas = this.facturaService.getFactura(id);
        if(facturas!=null){
            this.facturaService.deleteFactura(facturas);
            System.out.println("Borrado con éxito");
        }else {
            System.out.println("No encontrado");
        }
    }

    //MODIFICAR UNA FACTURA
    @PutMapping("api/factura/modify/{id}")
    public Mono<Facturas> modifFactura(@PathVariable("id") String id, @RequestBody Facturas factura){
        Facturas fromDB =this.facturaService.getFactura(id);
        if(fromDB!=null) {
            factura.setId(fromDB.getId());
            return Mono.just(facturaService.saveFactura(factura));
        }
        return null;
    }

    //BÚSQUEDA POR ESTADO
    @GetMapping("api/factura/estado/{estado}")
    public Flux<Facturas> getFacturaEstado(@PathVariable("estado") String estado){
        return Flux.fromIterable(facturaService.findByEstado(estado));
    }

    //BÚSQUEDA POR IMPORTE
    @GetMapping("api/factura/importe/{total}")
    public Flux<Facturas> getFacturaImporte(@PathVariable("total") double total){
        return Flux.fromIterable(facturaService.findByImporte(total));
    }

    //BÚSQUEDA POR ID CLIENTE
    @GetMapping("api/factura/cliente/{id}")
    public Flux<Facturas> getClienteId(@PathVariable("id") int id){
        return Flux.fromIterable(facturaService.findByIdcliente(id));
    }
}
