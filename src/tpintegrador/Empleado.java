package tpintegrador;

import tpintegrador.recursos.Persona;
import java.util.HashMap;
import java.util.Map;

public class Empleado extends Persona {
    
    private Map<Integer, Integer> vendidos;

    public Empleado(String nombre, String apellido, int dni) {
        super(nombre, apellido, dni);
        vendidos = new HashMap<>();
    }
    
    public void registrarVenta(int dniComprador, int idCode){
        this.vendidos.put(idCode, dniComprador);
    }
    
}
