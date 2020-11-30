package com.bootcamp.ejercicio.entidadesMySQL.domain;

import javax.persistence.*;

@Entity
@Table(name = "direccion")
public class Direccion {

    @Id
    private int id;

    @Column(name= "idcliente")
    private int idcliente;

    @Column(name= "poblacion")
    private String poblacion;

    @Column(name= "direccion")
    private String direccion;

    public Direccion(){

    }

    public Direccion(int id, int idcliente, String poblacion, String direccion) {
        this.id = id;
        this.idcliente = idcliente;
        this.poblacion = poblacion;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int clienteid) {
        this.idcliente = clienteid;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", idcliente=" + idcliente +
                ", poblacion='" + poblacion + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
