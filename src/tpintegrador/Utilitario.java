package tpintegrador;

import tpintegrador.recursos.Vehiculo;

public class Utilitario extends Vehiculo {
    private final String descripcion;

    public Utilitario(String Marca, String Modelo, String Color,int idCode,String descripcion,Boolean status) {
        super(Marca, Modelo, Color,idCode,status);
        this.descripcion = descripcion;
    }
    
    public Utilitario(String Marca, String Modelo, String Color,int idCode,String descripcion,Boolean status,int vendidoPor) {
        super(Marca, Modelo, Color,idCode,status,vendidoPor);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
}
