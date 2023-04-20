package tpintegrador;

import tpintegrador.recursos.DbConn; //

public class App {

    public static void main(String[] args){
        Concesionaria c1 = new Concesionaria();
        try {
            c1.run();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }        
    }
    
}
