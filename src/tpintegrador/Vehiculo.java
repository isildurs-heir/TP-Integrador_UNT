
package tpintegrador;

public abstract class Vehiculo {
    private String Marca;
    private String Modelo;
    private String Color;
    private int idCode;

    public Vehiculo(String Marca, String Modelo, String Color, int idCode) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Color = Color;
        this.idCode = idCode;
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
    
    
    
    
}
