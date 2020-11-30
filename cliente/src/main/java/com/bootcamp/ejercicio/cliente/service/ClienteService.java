package com.bootcamp.ejercicio.cliente.service;

import com.bootcamp.ejercicio.cliente.repositories.ClienteRepository;
import com.bootcamp.ejercicio.entidadesMySQL.domain.Cliente;
import com.bootcamp.ejercicio.entidadesMySQL.domain.Direccion;
import org.checkerframework.checker.nullness.Opt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {


    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    DireccionService direccionService;


    //MOSTRAR TODOS
    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }

    //MOSTRAR SOLO UNO POR EL ID
    public Cliente getCliente(int id){
        return clienteRepository.findById(id).get();
    }

    //GUARDAR UN CLIENTE
    public Cliente saveCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    //ELIMINAR CLIENTE
    public void deleteCliente(Cliente cliente){
        clienteRepository.delete(cliente);
    }

    //ELIMINAR UN CLIENTE POR ID
    public void deleteClienteByID(int id){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        clienteRepository.delete(cliente);

    }


    //MOSTRAR LOS CLIENTES POR ESTADO
    public List<Cliente> getClienteEstado(String estado){
        return clienteRepository.findByEstado(estado);
    }

    //MOSTRAR CLIENTE POR NOMBRE
    public String getClienteName(String name){
        String n="";
        for(Cliente cl : clienteRepository.findByNombre(name)){
            n=cl.getNombre()+"\t";
        }
        return n;
    }

    //MOSTRAR A TODOS LOS CLIENTES CON SU DIRECCION
    public String getClienteAllDireccion(){
        String s ="";
        for(Cliente cliente : clienteRepository.findAll()){
            s+="\n"+cliente.toString();
            for(Direccion direccion: direccionService.getAllDirecciones()){
                if(direccion.getIdcliente()!=cliente.getId()){
                }else{
                    s+="\n"+"\t"+direccion.toString();
                }
            }
        }
        return s;
    }

    //MOSTRAR UN CLIENTE CON SU POBLACION
    public String getClientePoblacion(int clientid){
        String n;
        Cliente cliente = clienteRepository.findById(clientid).orElse(null);
        //System.out.println(clienteService.getCliente(clientid).getNombre());
        n= cliente.getNombre()+"\n";
        for(Direccion d : direccionService.findByIdCliente(clientid)){
            n+="\t\t"+d.getPoblacion()+": "+d.getDireccion();
            //System.out.println(d.getPoblacion());

        }
        return n;
    }

    //MOSTRAR CLIENTE POR LA POBLACION
    public List<Cliente> getClienteProvincia(String prov){
        List<Cliente> cl = new ArrayList<>();
        for(Direccion d: direccionService.findByPoblacion(prov)){
            //d.getDireccion();
            int idCliente = d.getIdcliente();
            Cliente c = clienteRepository.findById(idCliente).orElse(null);
                cl.add(c);
        }
        return cl;
    }


}
