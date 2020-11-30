package com.example.ejercicio.pago.PagoMongo.services;

import com.example.clasesdto.clasedto.ClienteDTO;
import com.example.clasesdto.clasedto.FacturaDTO;
import com.example.ejercicio.entidadesMongo.Pagos;

import com.example.ejercicio.pago.PagoMongo.repositories.PagoMongoRepository;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagoMongoService {

   @Autowired
   PagoMongoRepository pagoMongoRepository;

    @Autowired
    RestTemplate llamadaBalanced;


    //MOSTRAR UN PAGO POR ID
    public Pagos getPago(String id){
        if(pagoMongoRepository.findById(id).get()!=null){
            return pagoMongoRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //MOSTRAR TODOS LOS PAGOS
    public List<Pagos> findAll(){
        return pagoMongoRepository.findAll();
    }

    //INSERTAR UN PAGO
    public Pagos savePago(Pagos pagos){
        return pagoMongoRepository.insert(pagos);
    }

    //ELIMINAR UN PAGO POR ID
    public void deletePagoById(String id){
        pagoMongoRepository.deleteById(id);
    }

    //ELIMINAR UN PAGO
    public void deletePago(Pagos pagos){
        pagoMongoRepository.delete(pagos);
    }

    //BÚSQUEDA POR ID FACTURA
    public List<Pagos> findByIdfactura(String id){
        return pagoMongoRepository.findByIdfactura(id);
    }

    //BÚSQUEDA POR ESTADO DEL PAGO
    public List<Pagos> findByEstado(String estado){
        return pagoMongoRepository.findByEstado(estado);
    }

    //BÚSQUEDA POR IdCliente
    public List<Pagos> findByClienteId(int id){
        List<Pagos> resultado = new ArrayList<>();
        ResponseEntity<FacturaDTO[]> response = llamadaBalanced.getForEntity("http://FacturaMongo/api/factura/cliente/"+id,FacturaDTO[].class);
        FacturaDTO[] facturas = response.getBody();
        for(FacturaDTO f : facturas){
           List<Pagos> pagosFactura = pagoMongoRepository.findByIdfactura(f.getId());
           for(Pagos p : pagosFactura){
               resultado.add(p);
           }
        }
        return resultado;
    }

    //BÚSQUEDA POR ESTADO DE UN CLIENTE
    public List<Pagos> findByEstadoCliente(String estado){
        List<Pagos> resultado = new ArrayList<>();
        ResponseEntity<ClienteDTO[]> response = llamadaBalanced.getForEntity("http://Cliente-Ejercicio/api/cliente/estado/"+estado, ClienteDTO[].class);
        ClienteDTO[] clientes = response.getBody();
        for (ClienteDTO c : clientes){
            List<Pagos> pagosCliente = findByClienteId(c.getId());
            for(Pagos p : pagosCliente){
                resultado.add(p);
            }
        }
        return resultado;
    }

    //BÚSQUEDA POR ESTADO DE UNA FACTURA
    public List<Pagos> findByEstadoFactura(String estado){
        List<Pagos> resultado = new ArrayList<>();
        ResponseEntity<FacturaDTO[]> response = llamadaBalanced.getForEntity("http://FacturaMongo/api/factura/estado/"+estado,FacturaDTO[].class);
        FacturaDTO[] facturas = response.getBody();
        for(FacturaDTO f : facturas){
            List<Pagos> pagosFactura = pagoMongoRepository.findByIdfactura(f.getId());
            for(Pagos p : pagosFactura){
                resultado.add(p);
            }
        }
        return resultado;
    }
}
