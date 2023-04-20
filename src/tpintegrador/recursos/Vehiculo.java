
package tpintegrador.recursos;

public abstract class Vehiculo {
    private String Marca;
    private String Modelo;
    private String Color;
    private int idCode;
    private Boolean status;

    public Vehiculo(String Marca, String Modelo, String Color, int idCode,Boolean status) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Color = Color;
        this.idCode = idCode;
        this.status = status;
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
        else return "Vendido";
    }

    @Override
    public String toString(){
        return(this.getMarca() + " " + this.getModelo() + " " + this.getColor() + " " + this.getId() + " " + this.statusToString());
    }
    
    public String toStringtoCliente(){
        return this.getMarca() + " " + this.getModelo() + " " + this.getColor() + " " + this.getId();
    }
    
    public String toStringToListado(){
        return this.getId()+")_ "+this.getMarca()+", "+this.getModelo()+" - "+this.getColor()+"   "+this.statusToString();
    }
    
    
}
