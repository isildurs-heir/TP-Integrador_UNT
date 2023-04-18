package tpintegrador;

import java.io.IOException;
import java.util.ArrayList;
import tpintegrador.recursos.Reader;
import tpintegrador.recursos.Vehiculo;


public class Repositor extends Reader {
    protected ArrayList<String[]> listado;
    
    public Repositor(){
        super();
        this.listado = new ArrayList<>();
    }
    
    /*public void carga(ArrayList<Vehiculo> catalogo) throws IOException{
        try{
            this.leerCsv(this.listado);
            for(String[] elemento : this.listado){
                int idCode = (int)(Math.random()*(999999-111111+1)+111111);
                switch(elemento[3]){
                    case "Auto" -> catalogo.add(new Auto(elemento[0],elemento[1],elemento[2],idCode,elemento[3]));
                    case "Camion" -> catalogo.add(new Camion(elemento[0],elemento[1],elemento[2],idCode,elemento[3]));
                    case "Utilitario" -> catalogo.add(new Utilitario(elemento[0],elemento[1],elemento[2],idCode,elemento[3]));
                }
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }*/
    
    public void carga(ArrayList<Vehiculo> catalogo) throws IOException{
        this.leerCsv(this.listado);
        for(String[] elemento : this.listado){
            int idCode = (int)(Math.random()*(999999-111111+1)+111111);
            switch(elemento[3]){
                case "Auto" -> {
                    if("true".equals(elemento[4])){
                        catalogo.add(new Auto(elemento[0],elemento[1],elemento[2],idCode,elemento[3],Boolean.valueOf(elemento[4])));
                    }
                    else{
                        catalogo.add(new Auto(elemento[0],elemento[1],elemento[2],idCode,elemento[3],Boolean.valueOf(elemento[4]),Integer.parseInt(elemento[5])));
                    }
                }
                case "Camion" -> {
                    if("true".equals(elemento[4])){
                        catalogo.add(new Camion(elemento[0],elemento[1],elemento[2],idCode,elemento[3],Boolean.valueOf(elemento[4])));
                    }
                    else{
                        catalogo.add(new Camion(elemento[0],elemento[1],elemento[2],idCode,elemento[3],Boolean.valueOf(elemento[4]),Integer.parseInt(elemento[5])));
                    }
                }
                case "Utilitario" ->{
                    if("true".equals(elemento[4])){
                        catalogo.add(new Utilitario(elemento[0],elemento[1],elemento[2],idCode,elemento[3],Boolean.valueOf(elemento[4])));
                    }
                    else{
                        catalogo.add(new Utilitario(elemento[0],elemento[1],elemento[2],idCode,elemento[3],Boolean.valueOf(elemento[4]),Integer.parseInt(elemento[5])));
                    }
                }
            }
        }
    }
    
    
}
