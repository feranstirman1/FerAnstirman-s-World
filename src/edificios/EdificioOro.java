
package edificios;

/**
 *
 * @author feranstirman
 */
public class EdificioOro extends Edificio {
    private int oroGenerado=100;
    
    public void RecolectarOro(CentroMando centromando){
        centromando.getOro().setCantidad(centromando.getOro().getCantidad()+oroGenerado);
    }
}
