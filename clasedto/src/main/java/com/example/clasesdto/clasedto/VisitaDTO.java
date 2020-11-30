package com.example.clasesdto.clasedto;

public class VisitaDTO {

    private int id;

    private double money;

    private int cliente;

    private String estados;

    private int idfactura;

    public VisitaDTO(){

    }

    public VisitaDTO(int id, double money, int cliente, String estados, int idfactura) {
        this.id = id;
        this.money = money;
        this.cliente = cliente;
        this.estados = estados;
        this.idfactura = idfactura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

}
