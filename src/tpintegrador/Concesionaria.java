package tpintegrador;

import java.io.IOException;
import java.sql.SQLException;
import tpintegrador.recursos.Vehiculo;
import java.util.ArrayList;

public class Concesionaria {
    private Repositor r1;
    private ArrayList<Vehiculo> catalogo;
    private ArrayList<Empleado> empleados;
    
    public Concesionaria(){
        this.catalogo = new ArrayList<>();
        this.empleados = new ArrayList<>();
    }
    
    public void cargaDeDB() throws SQLException{
        this.r1 = new Repositor();
        this.r1.getVehiculos(this.catalogo);
        this.r1.getEmpleados(this.empleados);
        this.r1.getVentas(this.empleados);
        for(Vehiculo vehiculo : this.catalogo){
            System.out.println(vehiculo.toString());
        }
        for(Empleado empleado : this.empleados){
            System.out.println(empleado.toString());
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
        this.cargaDeDB();
    }
    
    
}
