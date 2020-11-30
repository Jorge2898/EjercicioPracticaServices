package com.example.ejercicio.entidadesMongo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("LineaFactura")
public class LineaFactura {

    @Id
    private String id;

    private double money;

    private int cliente;

    private String estados;

    public LineaFactura() {
    }

    public LineaFactura(String id, double money, int cliente, String estados) {
        this.id = id;
        this.money = money;
        this.cliente = cliente;
        this.estados = estados;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getEstados() {
        return estados;
    }

    public void setEstados(String estados) {
        this.estados = estados;
    }
}

