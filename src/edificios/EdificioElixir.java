
package edificios;

/**
 *
 * @author feranstirman
 */
public class EdificioElixir extends Edificio {
    
    private int elixirGenerado=100;
    
    public void GenerarElixir(CentroMando centromando){
        centromando.getElixir().setCantidad(centromando.getElixir().getCantidad()+elixirGenerado);
    }
}
