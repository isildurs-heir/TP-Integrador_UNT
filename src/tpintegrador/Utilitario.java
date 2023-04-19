package tpintegrador;

import tpintegrador.recursos.Vehiculo;

public class Utilitario extends Vehiculo {
    private final String descripcion;

    public Utilitario(String Marca, String Modelo, String Color,int idCode,Boolean status,String descripcion) {
        super(Marca, Modelo, Color,idCode,status);
        this.descripcion = descripcion;
    }
    

    public String getDescripcion() {
        return descripcion;
    }
    
}
