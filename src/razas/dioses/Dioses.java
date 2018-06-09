
package razas.dioses;
import razas.Razas;

/**
 *
 * @author feranstirman
 */
public class Dioses extends Razas {
    
    //CONSTRUCTOR
    public Dioses(){
        this.setVidaRaza(500);
        this.setDañoRaza(200);
        this.setVelocidadConstruccion(1);
        this.setNombre("dios");
    }
    
    //METODOS
    public void PerderVida(){
        this.setVidaRaza(this.getVidaRaza()-this.getVidaRaza()/10);
    }

}
