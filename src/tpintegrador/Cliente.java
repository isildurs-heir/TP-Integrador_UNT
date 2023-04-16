package tpintegrador;

import tpintegrador.recursos.Persona;

public class Cliente extends Persona {
    
    private Vehiculo vehiculoComprado;
    
    public Cliente(String nombre, String apellido, int dni) {
        super(nombre, apellido, dni);
    }
    
    public void setVehiculo(Vehiculo vehiculoComprado){
        this.vehiculoComprado = vehiculoComprado;
    }
    
    
}
