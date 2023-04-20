package tpintegrador;

import tpintegrador.recursos.Vehiculo;
import tpintegrador.recursos.Persona;

public class Cliente extends Persona {
    
    private Vehiculo vehiculoComprado;
    
    public Cliente(String nombre, String apellido, int dni) {
        super(nombre, apellido, dni);
    }
    
    public void setVehiculo(Vehiculo vehiculoComprado){
        this.vehiculoComprado = vehiculoComprado;
    }
    
    public String vehiculoCompradoToString(){
        if(this.vehiculoComprado != null)
            return this.vehiculoComprado.toStringtoCliente();
        else
            return "";
    }
    
    @Override
    public String toString(){
        return super.toString()+" "+ this.vehiculoCompradoToString();
    }
    
    
}
