
package razas.mutantes;
import razas.Razas;

/**
 *
 * @author feranstirman
 */
public class Mutante extends Razas {
    
    //CONSTRUCTOR
    public Mutante(){
        setDañoRaza(getDañoRaza()*2);
        setVidaRaza(getVidaRaza()/2);
        setVelocidadConstruccion(2);
    }
    
    //METODOS
    public void RegenerarVida(){
        setVidaRaza(getVidaRaza()+ getVidaRaza()/10);
    }
}
