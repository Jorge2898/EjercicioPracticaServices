package com.bootcamp.ejercicio.visitasql.services;

import com.bootcamp.ejercicio.entidadesMySQL.domain.Visita;
import com.bootcamp.ejercicio.visitasql.repositories.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitaService {

    @Autowired
    VisitaRepository visitaRepository;

    //MOSTRAR TODAS LAS VISITAS
    public List<Visita> getAllVisitas(){
        return visitaRepository.findAll();
    }

    //MOSTRAR UNA VISITA POR ID
    public Visita getVisita(int id){
        return visitaRepository.findById(id).get();
    }

    //GUARDAR UNA VISITA
    public Visita saveVisita(Visita visita){
        return visitaRepository.save(visita);
    }

    //ELIMINAR UNA VISTA
    public void deleteVisita(Visita visita){
        visitaRepository.delete(visita);
    }

    //ELIMINAR UNA VISITA POR ID
    public void deleteVisitaByID(int id){
        Visita visita = visitaRepository.findById(id).orElse(null);
        visitaRepository.delete(visita);

    }

    //BÚSQUEDA DE VISITA POR CLIENTE
    public List<Visita> getVisitasByIdCliente(int id){
        return visitaRepository.findByCliente(id);
    }

    //BÚSQUEDA POR ESTADO DE VISITAS
    public List<Visita> getVisitasByEstados(String estados){
        return visitaRepository.findByEstados(estados);
    }
}
