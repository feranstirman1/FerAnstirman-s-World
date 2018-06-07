
package razas.mortales;
import razas.Raza;
/**
 *
 * @author feranstirman
 */
public class Mortal implements Raza {
    
    int daño=25;
    
    @Override
    public void Atacar(){
        System.out.println("El mortal ha hecho "+daño+" de daño");
    }
}
