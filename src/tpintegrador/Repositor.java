package tpintegrador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import tpintegrador.recursos.DbConn;
import tpintegrador.recursos.Reader;
import tpintegrador.recursos.Vehiculo;


public class Repositor extends Reader {
    protected ArrayList<String[]> listado;
    private final DbConn dbconn;
    
    public Repositor(){
        super();
        this.dbconn = new DbConn();
    }
    
    public void getVehiculos(ArrayList<Vehiculo> catalogo) throws SQLException{
        this.listado = new ArrayList<>();
        this.dbconn.Vehiculos(this.listado);
        for(String[] elemento: this.listado){
            catalogo.add(this.nuevoVehiculo(elemento));
        }
    }
    
    public void getEmpleados(ArrayList<Empleado> empleados) throws SQLException{
        this.listado = new ArrayList<>();
        this.dbconn.Empleados(this.listado);
        for(String[] elemento: this.listado){
            empleados.add(this.nuevoEmpleado(elemento));
        }
    }
    
    public void getVentas(ArrayList<Empleado> empleados) throws SQLException{
        this.listado = new ArrayList<>();
        for(Empleado empleado : empleados){
            this.dbconn.getVentasById(this.listado,empleado.getDni());
            for(String[] info : this.listado){
                empleado.registrarVenta(info[3]+","+info[4],info[0]+","+info[1]+","+info[2]);
            }
            this.listado.clear();
        }
        
    }
    
    private Empleado nuevoEmpleado(String[] elemento){
        return new Empleado(elemento[0],elemento[1],Integer.parseInt(elemento[2]));
    }
    
    private Vehiculo nuevoVehiculo(String[] elemento) {
        switch (elemento[5]) { 
            case "Auto" -> {return new Auto(elemento[0], elemento[1], elemento[2], Integer.parseInt(elemento[3]), Integer.parseInt(elemento[4]) == 1,elemento[4]);}
            case "Camion" -> {return new Camion(elemento[0], elemento[1], elemento[2], Integer.parseInt(elemento[3]), Integer.parseInt(elemento[4]) == 1,elemento[4]);}
            case "Utilitario" -> {return new Utilitario(elemento[0], elemento[1], elemento[2], Integer.parseInt(elemento[3]), Integer.parseInt(elemento[4]) == 1,elemento[4]);}
            default -> {return null;}
        }
    }
    
    public void cargaPorLista(ArrayList<Vehiculo> catalogo) throws IOException{
        this.leerCsv(this.listado);
        for(String[] elemento : this.listado){
            catalogo.add(this.nuevoVehiculo(elemento));
        }
    }
    
}
