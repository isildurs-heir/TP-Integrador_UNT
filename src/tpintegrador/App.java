package tpintegrador;

import tpintegrador.recursos.DbConn; //

public class App {

    public static void main(String[] args){
        Concesionaria c1 = new Concesionaria();
        //Repositor r1 = new Repositor();
        try {
            //r1.getVehiculos(catalogo);
            c1.run();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        

        System.out.println("no sme importa nada el error");
        
        
    }
    
}
