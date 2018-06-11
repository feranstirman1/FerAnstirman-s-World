
package vehiculos;
import razas.Razas;
/**
 *
 * @author feranstirman
 */
public class Vehiculo {
    
    private int velocidad;
    private String nombre;

    //GETTERS Y SETTERS
    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //METODOS
    public void Transportar(Razas raza){
        System.out.println("WIP");
    }
    
}
