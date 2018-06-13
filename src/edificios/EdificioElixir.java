
package edificios;

/**
 *
 * @author feranstirman
 */
public class EdificioElixir extends Edificio {
    
    private int elixirGenerado=100;
    
    public EdificioElixir(){
        this.setVida(500);
        this.setTipo("generador de elixir");
    }
    
    public void GenerarElixir(CentroMando centromando){
        centromando.getElixir().setCantidad(centromando.getElixir().getCantidad()+elixirGenerado);
    }
}
