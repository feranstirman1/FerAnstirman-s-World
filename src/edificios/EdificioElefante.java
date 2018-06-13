
package edificios;
import vehiculos.*;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class EdificioElefante extends Edificio {
    
    public EdificioElefante(){
        this.setVida(500);
        this.setTipo("edificio de elefantes");
    }
    
    public Elefante CrearElefante(){
        Elefante nuevoElefante = new Elefante();
        return nuevoElefante;
    }
}
