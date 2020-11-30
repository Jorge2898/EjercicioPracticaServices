package com.example.ejercicio.entidadesMongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Facturas")
public class Facturas {


    private @Id String id;

    private List<LineaFactura> lineafact;

    private String estado;

    private double total;

    private int idcliente;

    public Facturas() {
    }

    public Facturas(String id, List<LineaFactura> lineafact, String estado, double total, int idcliente) {
        this.id = id;
        this.lineafact = lineafact;
        this.estado = estado;
        this.total = total;
        this.idcliente = idcliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<LineaFactura> getLineafact() {
        return lineafact;
    }

    public void setLineafact(List<LineaFactura> lineafact) {
        this.lineafact = lineafact;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
}
