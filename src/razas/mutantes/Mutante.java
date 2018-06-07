
package razas.mutantes;
import razas.Raza;

/**
 *
 * @author feranstirman1
 */
public class Mutante implements Raza {
    
    int daño=50;
    
    @Override
    public void Atacar(){
        System.out.println("El mutante ha hecho "+daño+" de daño");
    }
}
