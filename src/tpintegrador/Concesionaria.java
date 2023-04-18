package tpintegrador;

import java.io.IOException;
import tpintegrador.recursos.Vehiculo;
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
        this.empleados = new ArrayList<>();
    }
    
    public Concesionaria(ArrayList<Vehiculo> catalogo){
        this.catalogo = catalogo;
    }
    
    /*public void cargaDeListado() throws IOException{
        try{
            Repositor r1 = new Repositor();        
            r1.carga(this.catalogo);
            for(Vehiculo vehiculo : this.catalogo){
                System.out.println(vehiculo.toString());
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }*/
    
    public void cargaDeListado() throws IOException{
        Repositor r1 = new Repositor();        
        r1.carga(this.catalogo);
        for(Vehiculo vehiculo : this.catalogo){
            System.out.println(vehiculo.toString());
        }
    }
    
    public void run() throws IOException{
        this.cargaDeListado();
    }
    
    
}
