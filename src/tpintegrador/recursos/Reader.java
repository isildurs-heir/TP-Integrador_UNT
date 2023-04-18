package tpintegrador.recursos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Reader {
    protected BufferedReader br;
    protected File file;

    public Reader() {
        this.br = null;
        this.file = new File("/home/lobo/Escritorio/Proyectos/TPIntegrador/src/tpintegrador/recursos/Ingreso.csv");
        
    }
    
    
    public void leerCsv(ArrayList<String[]> listado) throws IOException{ //excepcion no comprobada.. googlear
        if(!this.file.exists()){
            throw new IOException("no hay archivo para leer");
        }
        else{
            this.br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while(line != null){
                    listado.add(line.split(","));
                    line = br.readLine();
                }
                listado.remove(0);
                br.close();
        }
    }
    
    
}
