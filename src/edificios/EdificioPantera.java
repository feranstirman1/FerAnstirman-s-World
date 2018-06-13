
package edificios;
import vehiculos.*;

/**
 *
 * @author feranstirman
 */
public class EdificioPantera extends Edificio {
    
    public EdificioPantera(){
        this.setVida(800);
        this.setTipo("edificio de panteras");
    }
                
    public Pantera CrearPantera(){
        Pantera nuevaPantera=new Pantera();
        return nuevaPantera;
    }
}
