package com.example.ejercicio.entidadesMongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Pagos")
public class Pagos {

    @Id
    private String id;

    private double dinero;

    private String estado;

    private String idfactura;

    public Pagos() {
    }

    public Pagos(String id, double dinero, String estado, String idfactura) {
        this.id = id;
        this.dinero = dinero;
        this.estado = estado;
        this.idfactura = idfactura;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(String idfactura) {
        this.idfactura = idfactura;
    }
}
