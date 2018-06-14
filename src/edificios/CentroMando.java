
package edificios;
import materiales.*;

/**
 *
 * @author feranstirman
 */
public class CentroMando extends Edificio{
    
    public CentroMando(){ //LOS MATERIALES CON LOS QUE COMIENZA CADA JUGADOR
        
        this.setTipo("centromando");
        
        cobre= new Cobre();
        oro=new Oro();
        elixir= new Elixir();
        
        this.setVida(10000);
        this.setConstruido(true);
        cobre.setCantidad(900);
        oro.setCantidad(500);
        elixir.setCantidad(0);
        destruido=false;
    }
    
    private int nivel=0;
    private int capacidadCobre=10000;
    private int capacidadOro=5000;
    private int capacidadElixir=3000;
    private boolean destruido;

    //GETTER Y SETTER
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCapacidadCobre() {
        return capacidadCobre;
    }

    public void setCapacidadCobre(int capacidadCobre) {
        this.capacidadCobre = capacidadCobre;
    }

    public int getCapacidadOro() {
        return capacidadOro;
    }

    public void setCapacidadOro(int capacidadOro) {
        this.capacidadOro = capacidadOro;
    }

    public int getCapacidadElixir() {
        return capacidadElixir;
    }

    public void setCapacidadElixir(int capacidadElixir) {
        this.capacidadElixir = capacidadElixir;
    }

    public Cobre getCobre() {
        return cobre;
    }

    public void setCobre(Cobre cobre) {
        this.cobre = cobre;
    }

    public Oro getOro() {
        return oro;
    }

    public void setOro(Oro oro) {
        this.oro = oro;
    }

    public Elixir getElixir() {
        return elixir;
    }

    public void setElixir(Elixir elixir) {
        this.elixir = elixir;
    }
    
    private Cobre cobre;
    private Oro oro;
    private Elixir elixir;
    
    //METODOS
    /**
     * Sube el nivel del centro de mando, aumenta la capacidad de los materiales, y descuenta los materiales gastados
     */
    public void LevelUp(){
        int monto= ((capacidadCobre+capacidadElixir+capacidadOro)/4)/3;
        if(cobre.getCantidad()>=monto && oro.getCantidad()>=monto && elixir.getCantidad()>=monto){
            cobre.setCantidad(cobre.getCantidad()-monto);
            oro.setCantidad(oro.getCantidad()-monto);
            elixir.setCantidad(elixir.getCantidad()-monto);
            switch(nivel){
                case 0:
                    capacidadCobre+=capacidadCobre/10;
                    capacidadOro+=capacidadOro/10;
                    capacidadElixir+=capacidadElixir/10;
                    nivel=1;
                case 1:
                    capacidadCobre+=capacidadCobre/5;
                    capacidadOro+=capacidadOro/5;
                    capacidadElixir+=capacidadElixir/5;
                    nivel=2;
                case 2:
                    capacidadCobre+=3*capacidadCobre/10;
                    capacidadOro+=3*capacidadOro/10;
                    capacidadElixir+=3*capacidadElixir/10;
                    nivel=3;
                default:
                    System.out.println("YA NO PUEDE SUBIR MAS DE NIVEL");
            }
        }
        else{
            System.out.println("NO TIENE LOS MATERIALES NECESARIOS PARA SUBIR DE NIVEL");
        }
    }
    
    public void ActualizarCentro(){
        if(oro.getCantidad()>capacidadOro){
            oro.setCantidad(capacidadOro);
        }
        if(cobre.getCantidad()>capacidadCobre){
            cobre.setCantidad(capacidadCobre);
        }
        if(elixir.getCantidad()>capacidadElixir){
            elixir.setCantidad(capacidadElixir);
        }
    }
    
}
