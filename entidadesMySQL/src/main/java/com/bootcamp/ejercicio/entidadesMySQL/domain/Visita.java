package com.bootcamp.ejercicio.entidadesMySQL.domain;


import javax.persistence.*;

@Entity
@Table(name = "visitas")
public class Visita{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( name = "dinero")
    private double money;

    @Column (name = "idcliente")
    private int cliente;

    @Column (name= "estado")
    private String estados;

    @Column (name= "idfactura")
    private int idfactura;

    public Visita(){

    }

    public Visita(int id, double money, int cliente, String estados, int idfactura) {
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

    @Override
    public String toString() {
        return "Visita{" +
                "id=" + id +
                ", money=" + money +
                ", cliente=" + cliente +
                ", estados='" + estados + '\'' +
                ", idfactura=" + idfactura +
                '}';
    }
}
