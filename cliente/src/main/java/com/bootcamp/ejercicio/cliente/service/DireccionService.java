package com.bootcamp.ejercicio.cliente.service;

import com.bootcamp.ejercicio.cliente.repositories.DireccionRepository;
import com.bootcamp.ejercicio.entidadesMySQL.domain.Cliente;
import com.bootcamp.ejercicio.entidadesMySQL.domain.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionService {

    @Autowired
    DireccionRepository direccionRepository;

    public List<Direccion> findByIdCliente(int clientid) {
        return direccionRepository.findByIdcliente(clientid);
    }

    public List<Direccion> findByPoblacion(String name) {
        return direccionRepository.findByPoblacion(name);
    }

    //MOSTRAR TODAS LAS DIRECCIONES
    public List<Direccion> getAllDirecciones(){
        return direccionRepository.findAll();
    }

    //MOSTRAR SOLA UNA DIRECCION POR ID
    public Direccion getDireccion(int id){
        return direccionRepository.findById(id).get();
    }

    //GUARDAR UNA DIRECCION
    public Direccion saveDireccion(Direccion direccion){
        return direccionRepository.save(direccion);
    }

    //ELIMINAR UNA DIRECCION
    public void deleteDireccion(Direccion direccion){
        direccionRepository.delete(direccion);
    }

    //ELIMINAR UNA DIRECCION POR ID
    public void deleteDireccionById(int id){
        Direccion direccion= direccionRepository.findById(id).orElse(null);
        direccionRepository.delete(direccion);

    }

}
