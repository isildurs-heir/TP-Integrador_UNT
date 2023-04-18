package tpintegrador;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args){
        Concesionaria c1 = new Concesionaria();
        try {
            c1.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

        System.out.println("no sme importa nada el error");
        
        
    }
    
}
