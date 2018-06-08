
package razas.mutantes;
import razas.RazaFactory;
import razas.dioses.Dioses;
import razas.mortales.Mortal;

/**
 *
 * @author feranstirman
 */
public class MutantFactory implements RazaFactory {
    
    @Override
    public Mutante getMutante(String tipo){
        switch(tipo){
            case "ejercito":
                return new MutantArmy();
            case "especialista":
                return new WeaponX();
            default:
                return null;
        }
    }
    
    @Override
    public Mortal getMortal(String tipo){
        return null;
    }
    @Override
    public Dioses getDios(String tipo){
        return null;
    }
}
