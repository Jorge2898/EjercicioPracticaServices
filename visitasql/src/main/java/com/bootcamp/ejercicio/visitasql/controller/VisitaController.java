package com.bootcamp.ejercicio.visitasql.controller;

import com.bootcamp.ejercicio.entidadesMySQL.domain.Visita;
import com.bootcamp.ejercicio.visitasql.services.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitaController {

    @Autowired
    VisitaService visitaService;

    //PARA MOSTRAR UNA VISITA
    @GetMapping("api/visita/{id}")
    public Visita getVisita(@PathVariable("id") int visitaid) {
        return visitaService.getVisita(visitaid);
    }

    //MOSTRAR TODAS LAS VISITAS
    @GetMapping("api/visita/all")
    public List<Visita> getAllCliente() {
        return visitaService.getAllVisitas();
    }

    //INSERTAR UNA DIRECCION
    @PostMapping("api/visita/save")
    public Visita saveVisita(@RequestBody Visita visita) {
        return visitaService.saveVisita(visita);
    }

    //ELIMINAR UNA VISITA
    @DeleteMapping("api/visita/delete")
    public void deleteVisita(Visita visita){
        visitaService.deleteVisita(visita);
    }

    //ELIMINAR VISITA POR ID
    @DeleteMapping("api/visita/delete/{id}")
    public void deleteVisitaByID(@PathVariable("id") int id){
        visitaService.deleteVisitaByID(id);
    }

    //MODIFICAR UNA VISITA POR ID
    @PutMapping("api/visita/update/{id}")
    public Visita updateVisita(@PathVariable("id") int visitatid, @RequestBody Visita visita){
        Visita clientefromDB = this.visitaService.getVisita(visitatid);
        if(clientefromDB!=null){
            visita.setId(clientefromDB.getId());
            return visitaService.saveVisita(visita);
        }
        return null;
    }

    //BÚSQUEDA DE VISITAS POR ID DE UN CLIENTE
    @GetMapping("api/visita/cliente/id/{id}")
    public List<Visita> getVisitasByIdCliente(@PathVariable("id") int clienteid) {
        return visitaService.getVisitasByIdCliente(clienteid);
    }

    //BÚSQUEDA DE VISITAS POR ESTADO
    @GetMapping("api/visita/estado/{estado}")
    public List<Visita> getVisitasByEstado(@PathVariable("estado") String estado) {
        return visitaService.getVisitasByEstados(estado);
    }

}