package com.bootcamp.ejercicio.cliente.controller;


import com.bootcamp.ejercicio.cliente.service.ClienteService;
import com.bootcamp.ejercicio.cliente.service.DireccionService;
import com.bootcamp.ejercicio.entidadesMySQL.domain.Cliente;
import com.bootcamp.ejercicio.entidadesMySQL.domain.Direccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    DireccionService direccionService;

    //PARA MOSTRAR UN CLIENTE
    @GetMapping("api/cliente/{id}")
    public Cliente getCliente(@PathVariable("id") int clientid) {
        return clienteService.getCliente(clientid);
    }

    //MOSTRAR TODOS LOS CLIENTES
    @GetMapping("api/cliente/all")
    public List<Cliente> getAllCliente() {
        return clienteService.getAllClientes();
    }

    //MOSTRAR TODOS LOS CLIENTES CON SUS DIRECCIONES
    @GetMapping("api/cliente/all/direccion")
    public String getAllClienteDireccion() {
        return clienteService.getClienteAllDireccion();
    }

    //MOSTRAR CLIENTE NOMBRE POBLACION
    @GetMapping("api/cliente/nombre/{id}")
    public String getClientePoblacion(@PathVariable("id") int clientid){
        return clienteService.getClientePoblacion(clientid);
    }


    //INSERTAR CLIENTE
    @PostMapping("api/cliente/save")
    public Cliente saveCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    //ELIMINAR UN CLIENTE
    @DeleteMapping("api/cliente/delete")
    public void deleteCliente(Cliente cliente){
        clienteService.deleteCliente(cliente);
    }

    //ELIMINAR UN CLIENTE POR ID
    @DeleteMapping("api/cliente/delete/{id}")
    public void deleteClienteByID(@PathVariable("id") int id){
        clienteService.deleteClienteByID(id);
    }


    //MOSTRAR LOS CLIENTES POR NOMBRE
    @GetMapping("api/cliente/busnombre/{name}")
    public String getClienteNombre(@PathVariable("name") String name){
        return clienteService.getClienteName(name);
    }

    //MOSTRAR LOS CLIENTES POR PROVINCIA
    @GetMapping("api/cliente/poblacion/{name}")
    public List<Cliente> getClientePoblacion(@PathVariable("name") String name){
        return clienteService.getClienteProvincia(name);
    }

    //MOSTRAR LOS CLIENTES POR ESTADO
    @GetMapping("api/cliente/estado/{estado}")
    public List<Cliente> getClienteEstado(@PathVariable("estado") String estado){
        return clienteService.getClienteEstado(estado);
    }

    //UPDATE DE UN CLIENTE
    @PutMapping("api/cliente/update/{id}")
    public Cliente updateCliente(@PathVariable("id") int clientid, @RequestBody Cliente cliente){
        Cliente clientefromDB = this.clienteService.getCliente(clientid);
        if(clientefromDB!=null){
            cliente.setId(clientefromDB.getId());
            return clienteService.saveCliente(cliente);
        }
        return null;
    }
}
