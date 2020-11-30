package com.example.clasesdto.clasedto;

public class DireccionDTO {

    private int id;

    private int idcliente;

    private String poblacion;

    private String direccion;

    public DireccionDTO(){

    }

    public DireccionDTO(int id, int idcliente, String poblacion, String direccion) {
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

}
