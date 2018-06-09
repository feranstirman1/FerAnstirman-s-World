
package razas.mortales;
import razas.Razas;

/**
 *
 * @author feranstirman
 */
public class Mortal extends Razas {
    
    //CONSTRUCTOR
    public Mortal(){
        this.setVidaRaza(1000);
        this.setDañoRaza(100);
        this.setVelocidadConstruccion(3);
        this.setNombre("mortal");
    }
    
    
}
