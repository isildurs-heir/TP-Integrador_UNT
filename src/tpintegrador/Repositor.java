package tpintegrador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
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
            catalogo.add(this.createVehiculo(elemento));
        }
    }
    
    public void getEmpleados(ArrayList<Empleado> empleados) throws SQLException{
        this.listado = new ArrayList<>();
        this.dbconn.Empleados(this.listado);
        for(String[] elemento: this.listado){
            empleados.add(this.createEmpleado(elemento));
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
    
    public Cliente nuevoCliente() throws SQLException{
        String nombre,apellido;
        int dni;
        Scanner sc = new Scanner(System.in);
        this.listado = new ArrayList<>();
        
        System.out.println("Ingrese dni:");
        dni = sc.nextInt();
        sc.nextLine();
        this.dbconn.getClienteById(this.listado,dni);
        if(this.listado.isEmpty()){
            System.out.println("Ingrese nombre:");
            nombre = sc.nextLine();
            sc.nextLine();
            System.out.println("Ingrese apellido");
            apellido = sc.nextLine();
            sc.nextLine();
            this.dbconn.createCliente(nombre,apellido,dni);
        }
        else{
            System.out.println("Cliente ya registrado");
            nombre = this.listado.get(0)[0];
            apellido = this.listado.get(0)[1];
        }
        return new Cliente(nombre,apellido,dni);
    } //ver que onda
    
    public void getHistorialById(ArrayList<Vehiculo> catalogo,ArrayList<Empleado> empleados,int dni) throws SQLException{
        this.listado = new ArrayList<>();
        this.dbconn.getInfoById(this.listado,dni);
        if(!this.listado.isEmpty()){
            for(String[] info : this.listado){
                System.out.println("Compras registradas:");
                System.out.println("Vehiculo comprado: "+this.getVehiculoCatalogo(catalogo,Integer.parseInt(info[0])).toString()+"\nVendido por: "+this.getEmpleadosCatalogo(empleados,Integer.parseInt(info[1])));
            }
        }
        else{
            System.out.println("No se registran compras a nombre de este cliente.");
        }
    }
    
    public Vehiculo getVehiculoCatalogo(ArrayList<Vehiculo> catalogo,int idCode){
        for(Vehiculo vehiculo : catalogo){
            if(vehiculo.getId() == idCode){
                return vehiculo;
            }
        }
        return null;
    }
    
    public Empleado getEmpleadosCatalogo(ArrayList<Empleado> empleados, int dni){
        for(Empleado empleado : empleados){
            if(empleado.getDni() == dni){
                return empleado;
            }
        }
        return null;
    }
    
    public void nuevaVenta(Empleado empleado,Cliente cliente,Vehiculo vehiculo) throws SQLException{
        this.dbconn.createVenta(cliente.getDni(),empleado.getDni(),vehiculo.getId());
        vehiculo.setStatus(false);
        cliente.setVehiculo(vehiculo);
    }
    
    private boolean existeVehiculo(int idCode) throws SQLException{
        this.dbconn.getVehiculoById(this.listado, idCode);
        return !this.listado.isEmpty();
    }
    
    
    public void cargaPorLista(ArrayList<Vehiculo> catalogo) throws IOException, SQLException{
        this.listado = new ArrayList<>();
        this.leerCsv(this.listado);
        for(String[] elemento : this.listado){
            if(!this.existeVehiculo(Integer.parseInt(elemento[3]))){
                this.dbconn.createVehiculo(elemento[0],elemento[1],elemento[2],Integer.parseInt(elemento[3]),Integer.parseInt(elemento[4]),elemento[5]);
                catalogo.add(this.createVehiculo(elemento));
            }
        }
    }
    
    public Vehiculo buscarEnCatalogo(ArrayList<Vehiculo> catalogo,int idCode){
        for(Vehiculo vehiculo : catalogo){
            if(vehiculo.status()){
                if(vehiculo.getId() == idCode){
                    return vehiculo;
                }
            }
        }
        return null; //consultar
    }
    
    public void listarCatalogoDisponible(ArrayList<Vehiculo> catalogo){
        for(Vehiculo vehiculo : catalogo){
            if(vehiculo.status()){
                System.out.println(vehiculo.toStringToListado());
            }
        }
    }
    
    public void listarCatalogoCompleto(ArrayList<Vehiculo> catalogo){
        for(Vehiculo vehiculo : catalogo){
            System.out.println(vehiculo.toStringToListado());
        }
    }
    
    private Empleado createEmpleado(String[] elemento){
        return new Empleado(elemento[0],elemento[1],Integer.parseInt(elemento[2]));
    }
    
    private Vehiculo createVehiculo(String[] elemento) {
        switch (elemento[5]) { 
            case "Auto" -> {return new Auto(elemento[0], elemento[1], elemento[2], Integer.parseInt(elemento[3]), Integer.parseInt(elemento[4]) == 1,elemento[5]);}
            case "Camion" -> {return new Camion(elemento[0], elemento[1], elemento[2], Integer.parseInt(elemento[3]), Integer.parseInt(elemento[4]) == 1,elemento[5]);}
            case "Utilitario" -> {return new Utilitario(elemento[0], elemento[1], elemento[2], Integer.parseInt(elemento[3]), Integer.parseInt(elemento[4]) == 1,elemento[5]);}
            default -> {return null;}
        }
    }
}
