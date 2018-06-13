
package edificios;

/**
 *
 * @author feranstirman
 */
public class EdificioOro extends Edificio {
    private int oroGenerado=100;
    
    
    public  EdificioOro(){
        this.setVida(500);
        this.setTipo("recolector de oro");
    }
    
    public void RecolectarOro(CentroMando centromando){
        centromando.getOro().setCantidad(centromando.getOro().getCantidad()+oroGenerado);
    }
}
