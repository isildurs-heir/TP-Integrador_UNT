package tpintegrador;

import tpintegrador.recursos.Persona;
import java.util.HashMap;
import java.util.Map;

public class Empleado extends Persona {
    
    private Map<String,String> vendidos;

    public Empleado(String nombre, String apellido, int dni) {
        super(nombre, apellido, dni);
        vendidos = new HashMap<>();
    }
    
    public void registrarVenta(String vehiculoStr, String clienteStr){
        this.vendidos.put(vehiculoStr,clienteStr);
    }
    
    public String ventasToString(){
        return this.vendidos.toString();
    }
    
    @Override
    public String toString(){
        return super.toString() +" "+ this.ventasToString();
    }
    
}
