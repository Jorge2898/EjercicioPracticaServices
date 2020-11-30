package com.example.ejercicio.pago.PagoMongo.controller;

import com.example.ejercicio.entidadesMongo.Facturas;
import com.example.ejercicio.entidadesMongo.Pagos;
import com.example.ejercicio.pago.PagoMongo.services.PagoMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PagoMongoController {

    @Autowired
    PagoMongoService pagoMongoService;

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //MOSTRAR UN PAGO
    @GetMapping("api/pago/{id}")
    public Mono<Pagos> getPagoById(@PathVariable("id") String id){
        return Mono.just(pagoMongoService.getPago(id));
    }

    //MOSTRAR TODOS LOS PAGOS
    @GetMapping("api/pago/all")
    public Flux<Pagos> getPagoAll(){
        return Flux.fromIterable(pagoMongoService.findAll());
    }

    //INSERTAR UN PAGO
    @PostMapping("api/pago/insert")
    public Mono<Pagos> insertPago(@RequestBody Pagos pagos){
        return Mono.just(pagoMongoService.savePago(pagos));
    }

    //ELIMINAR UN PAGO POR ID
    @DeleteMapping("api/pago/delete/{id}")
    public void deletePago(@PathVariable("id") String id){
        Pagos pagos = this.pagoMongoService.getPago(id);
        if(pagos!=null){
            this.pagoMongoService.deletePago(pagos);
            System.out.println("Borrado con éxito");
        }else {
            System.out.println("No encontrado");
        }
    }

    //MODIFICAR UNA FACTURA
    @PutMapping("api/pago/modify/{id}")
    public Mono<Pagos> modifFactura(@PathVariable("id") String id, @RequestBody Pagos pagos){
        Pagos fromDB =this.pagoMongoService.getPago(id);
        if(fromDB!=null) {
            pagos.setId(fromDB.getId());
            return Mono.just(pagoMongoService.savePago(pagos));
        }
        return null;
    }

    //BÚSQUEDA POR ID DE FACTURA
    @GetMapping("api/pago/factura/{id}")
    public Flux<Pagos> getPagoByIdfactura(@PathVariable("id") String id){
        return Flux.fromIterable(pagoMongoService.findByIdfactura(id));
    }

    //BÚSQUEDA POR ESTADO DEL PAGO
    @GetMapping("api/pago/estado/{estado}")
    public Flux<Pagos> getPagoByEstado(@PathVariable("estado") String estado){
        return Flux.fromIterable(pagoMongoService.findByEstado(estado));
    }


    //BÚSQUEDA POR IdCliente
    @GetMapping("api/pago/cliente/{id}")
    public Flux<Pagos> getPagoByClienteId(@PathVariable("id") int id){
        return Flux.fromIterable(pagoMongoService.findByClienteId(id));
    }

    //BÚSQUEDA POR ESTADO CLIENTE
    @GetMapping("api/pago/cliente/estado/{estado}")
    public Flux<Pagos> getPagoByClienteEstado(@PathVariable("estado") String estado){
        return Flux.fromIterable(pagoMongoService.findByEstado(estado));
    }

    //BUSQUEDA POR ESTADO DE FACTURA
    @GetMapping("api/pago/factura/estado/{estado}")
    public Flux<Pagos> getPagoByFacturaEstado(@PathVariable("estado") String estado){
        return Flux.fromIterable(pagoMongoService.findByEstadoFactura(estado));
    }

}
