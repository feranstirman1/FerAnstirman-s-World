
package edificios;

/**
 *
 * @author feranstirman
 */
public class EdificioCobre extends Edificio {
    
    int cobreGenerado=50;
    
    public EdificioCobre(){
        this.setVida(200);
        this.setTipo("recolector de cobre");
    }
    
    
    //METODOS
    public void RecolectarCobre(CentroMando centromando){
        centromando.getCobre().setCantidad(centromando.getCobre().getCantidad()+cobreGenerado);
    }
}
