
package edificios;

/**
 *
 * @author feranstirman
 */
public class EdificioCobre extends Edificio {
    
    int cobreGenerado=50;
    
    //METODOS
    public void RecolectarCobre(CentroMando centromando){
        centromando.getCobre().setCantidad(centromando.getCobre().getCantidad()+cobreGenerado);
    }
}
