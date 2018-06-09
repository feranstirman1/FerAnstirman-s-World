
package razas.mutantes;
import razas.Razas;

/**
 *
 * @author feranstirman
 */
public class Mutante extends Razas {
    
    //CONSTRUCTOR
    public Mutante(){
        this.setVidaRaza(1000);
        this.setDañoRaza(150);
        this.setVelocidadConstruccion(2);
    }
    
    //METODOS
    public void RegenerarVida(){
        this.setVidaRaza(this.getVidaRaza()+this.getVidaRaza()/10);
    }
}
