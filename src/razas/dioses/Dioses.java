
package razas.dioses;
import razas.Razas;

/**
 *
 * @author feranstirman
 */
public class Dioses extends Razas {
    
    //CONSTRUCTOR
    public Dioses(){
        setVidaRaza(getVidaRaza()*2);
        setDañoRaza(getDañoRaza()*2);
        setVelocidadConstruccion(1);
    }
    
    //METODOS
    public void PerderVida(){
        setVidaRaza(getVidaRaza()- getVidaRaza()/10);
    }

}
