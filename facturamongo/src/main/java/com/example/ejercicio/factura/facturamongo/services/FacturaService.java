package com.example.ejercicio.factura.facturamongo.services;

import com.example.ejercicio.entidadesMongo.Facturas;
import com.example.ejercicio.factura.facturamongo.repositories.FacturaRepository;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    //MOSTRAR UNA FACTURA POR ID
    public Facturas getFactura(String id){
        if(facturaRepository.findById(id).get()!=null){
           return facturaRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //MOSTRAR TODAS LAS FACTURAS
    public List<Facturas> findAll(){
        return facturaRepository.findAll();
    }

    //INSERTAR UNA FACTURA
    public Facturas saveFactura(Facturas factura){
        return facturaRepository.insert(factura);
    }

    //ELIMINAR UNA FACTURA POR ID
    public void deleteFacturaById(String id){
        facturaRepository.deleteById(id);
    }

    //ELIMINAR UNA FACTURA
    public void deleteFactura(Facturas facturas){
        facturaRepository.delete(facturas);
    }

    //BÚSQUEDA POR ESTADO
    public List<Facturas> findByEstado(String estado){
        return facturaRepository.findByEstado(estado);
    }

    //BÚSQUEDA POR IMPORTE
    public List<Facturas> findByImporte(double total){
        return facturaRepository.findByTotal(total);
    }

    //BÚSQUEDA POR CLIENTE
    public List<Facturas> findByIdcliente(int id){
        return facturaRepository.findByIdcliente(id);
    }

}
