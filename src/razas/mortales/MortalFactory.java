
package razas.mortales;
import razas.RazaFactory;
import razas.dioses.Dioses;
import razas.mutantes.Mutante;

/**
 *
 * @author feranstirman
 */
public class MortalFactory implements RazaFactory {
    
    @Override
    public Mortal getMortal(String tipo){
        switch(tipo){
            case "ejercito":
                return new MortalArmy();
            case "especialista":
                return new SuperSoldier();
            default:
                return null;
        }
    }
    
    @Override
    public Dioses getDios(String tipo){
        return null;
    }
    @Override
    public Mutante getMutante(String tipo){
        return null;
    }
}
