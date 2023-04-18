
package tpintegrador.recursos;

public abstract class Vehiculo {
    private String Marca;
    private String Modelo;
    private String Color;
    private int idCode;
    private Boolean status;
    private int vendidoPor;

    public Vehiculo(String Marca, String Modelo, String Color, int idCode,Boolean status) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Color = Color;
        this.idCode = idCode;
        this.status = status;
    }
    
    public Vehiculo(String Marca, String Modelo, String Color, int idCode,Boolean status,int vendidoPor){
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Color = Color;
        this.idCode = idCode;
        this.status = status;
        this.vendidoPor = vendidoPor;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public int getId() {
        return idCode;
    }

    public void setId(int idCode) {
        this.idCode = idCode;
    }

    public boolean status() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String statusToString(){
        if(this.status) return "Disponible";
        else return "Vendido por Vendedor: " + this.getVendidoPor();
    }

    public int getVendidoPor() {
        return vendidoPor;
    }

    public void setVendidoPor(int vendidoPor) {
        this.vendidoPor = vendidoPor;
    }
    
    
    
    
    
    @Override
    public String toString(){
        return(this.getMarca() + " " + this.getModelo() + " " + this.getColor() + " " + this.getId() + " " + this.statusToString());
    }
    
    
}
