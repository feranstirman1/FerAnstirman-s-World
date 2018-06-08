
package razas.dioses;
import razas.RazaFactory;
import razas.mortales.Mortal;
import razas.mutantes.Mutante;
/**
 *
 * @author feranstirman
 */
public class GodFactory implements RazaFactory {
    
    @Override
    /**
     * Crea el tipo de dios que queremos
     */
    public Dioses getDios(String tipo){
        switch(tipo){
            case "ejercito":
                return new GodArmy();
            case "especialista":
                return new Zeus();
            default:
                return null;
        }
    }
    
    @Override
    public Mutante getMutante(String tipo){
        return null;
    }
    @Override
    public Mortal getMortal(String tipo){
        return null;
    }
}
