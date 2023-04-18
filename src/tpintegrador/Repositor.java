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
        this.listado = new ArrayList<>();
        this.dbconn = new DbConn();
    }
    
    public void getVehiculos(ArrayList<Vehiculo> catalogo) throws SQLException{
        this.dbconn.Vehiculos(this.listado);
        for(String[] elemento: this.listado){
            catalogo.add(this.nuevoVehiculo(elemento));
        }
    }
    
    public void cargaPorLista(ArrayList<Vehiculo> catalogo) throws IOException{
        this.leerCsv(this.listado);
        for(String[] elemento : this.listado){
            catalogo.add(this.nuevoVehiculo(elemento));
        }
    }
    
    private Vehiculo nuevoVehiculo(String[] elemento) {
        int idCode = Integer.parseInt(elemento[6]);
        switch (elemento[3]) {
            case "Auto" -> {
                if (Integer.parseInt(elemento[4]) == 1) {
                    return new Auto(elemento[0], elemento[1], elemento[2], idCode, elemento[3], Integer.parseInt(elemento[4]) == 1);
                } else {
                    return new Auto(elemento[0], elemento[1], elemento[2], idCode, elemento[3], Integer.parseInt(elemento[4]) == 1, Integer.parseInt(elemento[5]));
                }
            }
            case "Camion" -> {
                if (Integer.parseInt(elemento[4]) == 1) {
                    return new Camion(elemento[0], elemento[1], elemento[2], idCode, elemento[3], Integer.parseInt(elemento[4]) == 1);
                } else {
                    return new Camion(elemento[0], elemento[1], elemento[2], idCode, elemento[3], Integer.parseInt(elemento[4]) == 1, Integer.parseInt(elemento[5]));
                }
            }
            case "Utilitario" -> {
                if (Integer.parseInt(elemento[4]) == 1) {
                    return new Utilitario(elemento[0], elemento[1], elemento[2], idCode, elemento[3], Integer.parseInt(elemento[4]) == 1);
                } else {
                    return new Utilitario(elemento[0], elemento[1], elemento[2], idCode, elemento[3], Integer.parseInt(elemento[4]) == 1, Integer.parseInt(elemento[5]));
                }
            }
            default -> {
                return null;
            }
        }
    }
    
    
}
