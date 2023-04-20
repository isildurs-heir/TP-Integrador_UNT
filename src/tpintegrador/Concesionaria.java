package tpintegrador;

import java.io.IOException;
import java.sql.SQLException;
import tpintegrador.recursos.Vehiculo;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Concesionaria {
    private Repositor r1;
    private ArrayList<Vehiculo> catalogo;
    private ArrayList<Empleado> empleados;
    private Cliente cliente;
    private Vehiculo vehiculoMuestra;
    
    public Concesionaria(){
        this.catalogo = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.cliente = null;
        this.vehiculoMuestra = null;
    }
    
    public void cargaDeDB() throws SQLException{
        this.r1.getVehiculos(this.catalogo);
        this.r1.getEmpleados(this.empleados);
        this.r1.getVentas(this.empleados);
    }
    
    public void cargaDeListado() throws IOException{       
        this.r1.cargaPorLista(this.catalogo);
    }
    
    public void run() throws IOException, SQLException{
        this.r1 = new Repositor();
        this.cargaDeListado();
        this.cargaDeDB();
        this.cliente = this.r1.nuevoCliente();
        this.atenderCliente();
        
    }
    
    public void atenderCliente() throws SQLException{
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        Empleado empleado = this.empleados.get(rand.nextInt(3));
        System.out.println("Vendedor asignado: "+empleado.toString());
        int op = -1;
        int idCode;
        while(op != 0){
            System.out.println("1)_Comprar un vehiculo.\n2)_Ver catalogo.\n3)_Historial de compras a mi nombre.\n0)_Salir.");
            op = sc.nextInt();
            switch(op){
                case 1 -> {
                    this.r1.listarCatalogoDisponible(this.catalogo);
                    idCode = sc.nextInt();
                    this.r1.nuevaVenta(empleado,this.cliente,r1.buscarEnCatalogo(this.catalogo,idCode));
                }
                case 2 -> {
                    this.r1.listarCatalogoCompleto(this.catalogo);
                }
                case 3 -> {
                    this.r1.getHistorialById(this.catalogo,this.empleados,this.cliente.getDni());
                }
                case 0 -> {
                    System.out.println("Cerrando Atencion\n"+this.cliente.toString());
                }
                default -> {
                    System.out.println("Opcion incorrecta.");
                }
            }
        }
    }
}
