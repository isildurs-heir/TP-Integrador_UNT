package tpintegrador.recursos;

import java.sql.*;
import java.util.ArrayList;

public class DbConn {
    
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver"; //cambiar para jdbc de mysql
    static final String DB_URL = "jdbc:mariadb://localhost:3306/untIntegrador";
    //credenciales
    static final String USER = "root";
    static final String PWD = "Gondor.22";
    private Connection conn;
    private Statement stmt;
    
    public DbConn(){
        this.conn = null;
        this.stmt = null;
    }
    
    public void Vehiculos(ArrayList<String[]> datos) throws SQLException{
        this.createConn();
        String query = """
                       SELECT Vehiculo.marca,Vehiculo.modelo,Vehiculo.color,Vehiculo.idCode,Vehiculo.estado,Tipo.descripcion
                       FROM Vehiculo INNER JOIN Tipo on Vehiculo.tipo = Tipo.id;""";
        ResultSet result = this.runQuery(query);
        while(result.next()){
            String[] vehiculo = new String[6];
            vehiculo[0] = result.getString(1);
            vehiculo[1] = result.getString(2);
            vehiculo[2] = result.getString(3);
            vehiculo[3] = result.getString(4);
            vehiculo[4] = result.getString(5);
            vehiculo[5] = result.getString(6);
            datos.add(vehiculo);
        }
        this.closeConn();
    }
    
    public void Empleados(ArrayList<String[]> datos) throws SQLException{
        this.createConn();
        String query = "SELECT * FROM Empleado";
        ResultSet result = this.runQuery(query);
        while(result.next()){
            String[] empleado = new String[3];
            empleado[0] = result.getString(1);
            empleado[1] = result.getString(2);
            empleado[2] = result.getString(3);
            datos.add(empleado);
        }
        this.closeConn();
    }
 
    public void getVentasById(ArrayList<String[]> datos,int dni) throws SQLException{
        this.createConn();
        String query = String.format("""
                       SELECT Cliente.nombre,Cliente.apellido,Cliente.dni,Vehiculo.marca,Vehiculo.modelo
                       FROM Cliente INNER JOIN Vendido on Cliente.dni = Vendido.idComprador
                                    INNER JOIN Vehiculo on Vehiculo.idCode = Vendido.idCode WHERE Vendido.idVendedor = %s;
                       """,dni);
        ResultSet result = this.runQuery(query);
        while(result.next()){
            String[] ventas = new String[5];
            ventas[0] = result.getString(1);
            ventas[1] = result.getString(2);
            ventas[2] = result.getString(3);
            ventas[3] = result.getString(4);
            ventas[4] = result.getString(5);
            datos.add(ventas);
        }
        this.closeConn();
    }
    
    public void getInfoById(ArrayList<String[]> datos,int dni) throws SQLException{
        this.createConn();
        String query = String.format("SELECT idCode,idVendedor FROM Vendido WHERE idComprador = %s",dni);
        ResultSet result = this.runQuery(query);
        while(result.next()){
            String[] info = new String[2];
            info[0] = result.getString(1);
            info[1] = result.getString(2);
            datos.add(info);
        }
        this.closeConn();
    }
    
    public void getClienteById(ArrayList<String[]> datos, int dni) throws SQLException{
        this.createConn();
        String query = String.format("SELECT nombre,apellido FROM Cliente WHERE dni = %s",dni);
        ResultSet result = this.runQuery(query);
        while(result.next()){
            String[] info = new String[2];
            info[0] = result.getString(1);
            info[1] = result.getString(2);
            datos.add(info);
        }
        this.closeConn();
    }
    
    public void createCliente(String nombre,String apellido ,int dni) throws SQLException{
        this.createConn();
        String query = String.format("INSERT INTO Cliente (nombre,apellido,dni) VALUES('%s','%s',%s);",nombre,apellido,dni);
        this.runQuery(query);
    }
    
    public void createVenta(int dniComprador,int dniVendedor,int idCode) throws SQLException{
        this.createConn();
        String query = String.format("UPDATE Vehiculo SET estado = 0 WHERE idCode = %s",idCode);
        this.runQuery(query);
        query = String.format("INSERT INTO Vendido (idComprador,idVendedor,idCode) VALUES (%s,%s,%s);",dniComprador,dniVendedor,idCode);
        this.runQuery(query);
    }
    
    private void createConn(){
        try{
            conn = DriverManager.getConnection(DB_URL,USER,PWD);
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    private ResultSet runQuery(String query) throws SQLException{
        this.stmt = this.conn.createStatement();
        return this.stmt.executeQuery(query);
    }
    
    private void closeConn() throws SQLException{
        this.conn.close();
    }
    
    
    
}
