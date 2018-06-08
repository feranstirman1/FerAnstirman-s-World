
package razas;
import razas.dioses.Dioses;
import razas.mortales.Mortal;
import razas.mutantes.Mutante;

/**
 *
 * @author feranstirman
 */
public interface RazaFactory {
    Dioses getDios(String tipo);
    Mutante getMutante(String tipo);
    Mortal getMortal(String tipo);
}
