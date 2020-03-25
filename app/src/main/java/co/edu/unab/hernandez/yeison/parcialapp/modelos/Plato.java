package co.edu.unab.hernandez.yeison.parcialapp.modelos;

import java.io.Serializable;

public class Plato implements Serializable {
    private String nombrePlato,descripciónPlato,fotoPlato;
    private  int cantidadPlato;
    private double precioPlato;


    public Plato(String nombrePlato, String descripciónPlato, String fotoPlato, int cantidadPlato, double precioPlato) {
        this.nombrePlato = nombrePlato;
        this.descripciónPlato = descripciónPlato;
        this.fotoPlato = fotoPlato;
        this.cantidadPlato = cantidadPlato;
        this.precioPlato = precioPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getDescripciónPlato() {
        return descripciónPlato;
    }

    public void setDescripciónPlato(String descripciónPlato) {
        this.descripciónPlato = descripciónPlato;
    }

    public String getFotoPlato() {
        return fotoPlato;
    }

    public void setFotoPlato(String fotoPlato) {
        this.fotoPlato = fotoPlato;
    }

    public int getCantidadPlato() {
        return cantidadPlato;
    }

    public void setCantidadPlato(int cantidadPlato) {
        this.cantidadPlato = cantidadPlato;
    }

    public double getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(double precioPlato) {
        this.precioPlato = precioPlato;
    }
}
