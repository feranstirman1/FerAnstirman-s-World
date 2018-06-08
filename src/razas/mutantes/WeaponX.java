
package razas.mutantes;

/**
 *
 * @author feranstirman
 */
public class WeaponX extends Mutante{
    
    //CONSTRUCTOR
    public WeaponX(){
        setDañoRaza(getVidaRaza()*2);
        setVidaRaza(getVidaRaza()/2);
    }
}
