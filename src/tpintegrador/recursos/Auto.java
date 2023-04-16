package tpintegrador.recursos;

import tpintegrador.Vehiculo;

public class Auto extends Vehiculo {
    private final String descripcion;

    public Auto(String descripcion, String Marca, String Modelo, String Color,int idCode) {
        super(Marca, Modelo, Color,idCode);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    
    
    
}
