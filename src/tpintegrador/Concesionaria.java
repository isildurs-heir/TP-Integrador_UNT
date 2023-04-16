package tpintegrador;

import java.util.ArrayList;

public class Concesionaria {
    private ArrayList<Vehiculo> catalogo;
    private ArrayList<Empleado> empleados;

    public Concesionaria(ArrayList<Vehiculo> catalogo, ArrayList<Empleado> empleados) {
        this.catalogo = catalogo;
        this.empleados = empleados;
    }
    
    public Concesionaria(){
        this.catalogo = new ArrayList<>();
        this.catalogo = new ArrayList<>();
    }
    
    public void run(){
        String run = "do some shit";
    }
    
    
}
