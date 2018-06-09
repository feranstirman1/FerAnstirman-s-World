
package materiales;

/**
 *
 * @author feranstirman
 */
public class Material {
    
    private String nombre;
    private int cantidad=0;

    //GETTER Y SETTER
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
