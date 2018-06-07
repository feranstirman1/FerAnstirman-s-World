
package razas.dioses;
import razas.Raza;
/**
 *
 * @author feranstirman
 */
public class Dios implements Raza {
    
    private int daño= 100;
    
    
    @Override
    public void Atacar(){
        System.out.println("Los dioses han hecho "+daño+" de daño");
    }
}
