
package tpintegrador;

public class Camion extends Vehiculo {
    private final String descripcion;

    public Camion(String descripcion, String Marca, String Modelo, String Color,int idCode) {
        super(Marca, Modelo, Color,idCode);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
