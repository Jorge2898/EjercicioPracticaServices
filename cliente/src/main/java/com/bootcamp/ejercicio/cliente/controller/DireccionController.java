package com.bootcamp.ejercicio.cliente.controller;


import com.bootcamp.ejercicio.cliente.service.DireccionService;
import com.bootcamp.ejercicio.entidadesMySQL.domain.Cliente;
import com.bootcamp.ejercicio.entidadesMySQL.domain.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DireccionController {


    @Autowired
    DireccionService direccionService;

    //PARA MOSTRAR UNA DIRECCION
    @GetMapping("api/direccion/{id}")
    public Direccion getDireccion(@PathVariable("id") int direccionid) {
        return direccionService.getDireccion(direccionid);
    }

    //MOSTRAR TODAS LAS DIRECCIONES
    @GetMapping("api/direccion/all")
    public List<Direccion> getAllDireccion() {
        return direccionService.getAllDirecciones();
    }


    //INSERTAR DIRECCION
    @PostMapping("api/direccion/save")
    public Direccion saveDireccion(@RequestBody Direccion direccion) {
        return direccionService.saveDireccion(direccion);
    }

    //ELIMINAR UNA DIRECCION
    @DeleteMapping("api/direccion/delete")
    public void deleteDireccion(Direccion direccion){
        direccionService.deleteDireccion(direccion);
    }

    //ELIMINAR UNA DIRECCION POR ID
    @DeleteMapping("api/direccion/delete/{id}")
    public void deleteDireccionByID(@PathVariable("id") int id){
        direccionService.deleteDireccionById(id);
    }

    //UPDATE DE UN DIRECCION
    @PutMapping("api/direccion/update/{id}")
    public Direccion updateDireccion(@PathVariable("id") int direccionid, @RequestBody Direccion direccion){
        Direccion direccionfromDB = this.direccionService.getDireccion(direccionid);
        if(direccionfromDB!=null){
            direccion.setId(direccionfromDB.getId());
            return direccionService.saveDireccion(direccion);
        }
        return null;
    }

}
