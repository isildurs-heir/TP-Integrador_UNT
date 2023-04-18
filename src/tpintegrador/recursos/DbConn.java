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
                       SELECT Vehiculo.marca,Vehiculo.modelo,Vehiculo.color,Tipo.descripcion,Vehiculo.estado,Vehiculo.vendidoPor,Vehiculo.idCode
                       FROM Vehiculo INNER JOIN Tipo on Vehiculo.tipo = Tipo.id;""";
        ResultSet result = this.runQuery(query);
        while(result.next()){
            String[] vehiculo = new String[7];
            vehiculo[0] = result.getString(1);
            vehiculo[1] = result.getString(2);
            vehiculo[2] = result.getString(3);
            vehiculo[3] = result.getString(4);
            vehiculo[4] = result.getString(5);
            vehiculo[5] = result.getString(6);
            vehiculo[6] = result.getString(7);
            datos.add(vehiculo);
        }
        this.closeConn();
    }
    
    
    public void createConn(){
        try{
            System.out.println("Connecting");
            conn = DriverManager.getConnection(DB_URL,USER,PWD);
            System.out.println("Connected");
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public ResultSet runQuery(String query) throws SQLException{
        this.stmt = this.conn.createStatement();
        return this.stmt.executeQuery(query);
    }
    
    public void closeConn() throws SQLException{
        this.conn.close();
    }
    
    
    
}
