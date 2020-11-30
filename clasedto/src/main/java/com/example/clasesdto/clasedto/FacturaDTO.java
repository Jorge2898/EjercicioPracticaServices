package com.example.clasesdto.clasedto;

import java.util.List;

public class FacturaDTO {

    private String id;

    private List<VisitaDTO> lineafact;

    private String estado;

    private double total;

    public FacturaDTO() {
    }

    public FacturaDTO(String id, List<VisitaDTO> lineafact, String estado, double total) {
        this.id = id;
        this.lineafact = lineafact;
        this.estado = estado;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<VisitaDTO> getLineafact() {
        return lineafact;
    }

    public void setLineafact(List<VisitaDTO> lineafact) {
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

    @Override
    public String toString() {
        return "FacturaDTO{" +
                "id='" + id + '\'' +
                ", lineafact=" + lineafact +
                ", estado='" + estado + '\'' +
                ", total=" + total +
                '}';
    }
}
