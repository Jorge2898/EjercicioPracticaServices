package com.example.clasesdto.clasedto;

public class PagoDTO {

    private String id;

    private double dinero;

    private String estado;

    private int idfactura;

    public PagoDTO() {
    }

    public PagoDTO(String id, double dinero, String estado, int idfactura) {
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

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }
}
