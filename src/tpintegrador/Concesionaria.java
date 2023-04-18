package tpintegrador;

import java.io.IOException;
import java.sql.SQLException;
import tpintegrador.recursos.Vehiculo;
import java.util.ArrayList;

public class Concesionaria {
    private Repositor r1;
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
    
    public void cargaDeDB() throws SQLException{
        this.r1 = new Repositor();
        this.r1.getVehiculos(this.catalogo);
        for(Vehiculo vehiculo : this.catalogo){
            System.out.println(vehiculo.toString());
        }
    }
    
    public void cargaDeListado() throws IOException{
        this.r1 = new Repositor();        
        this.r1.cargaPorLista(this.catalogo);
        for(Vehiculo vehiculo : this.catalogo){
            System.out.println(vehiculo.toString());
        }
    }
    
    public void run() throws IOException, SQLException{
        this.cargaDeListado();
    }
    
    
}
