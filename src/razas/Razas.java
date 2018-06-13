
package razas;
import edificios.*;

/**
 *
 * @author feranstirman
 */
public class Razas implements Raza {
    
    private int dañoRaza;
    private int vidaRaza;
    private int velocidadConstruccion;
    private String nombre;
    
    private boolean entrenada;
    private boolean disponible;
    
    
    private Razas razaEnemiga;         //ATRIBUTOS PARA ATACAR AL ENEMIGO
    private Edificio edificioEnemigo;
    

        //GETTERS Y SETTERS

    public Razas getRazaEnemiga() {
        return razaEnemiga;
    }

    public void setRazaEnemiga(Razas razaEnemiga) {
        this.razaEnemiga = razaEnemiga;
    }

    public Edificio getEdificioEnemigo() {
        return edificioEnemigo;
    }

    public void setEdificioEnemigo(Edificio edificioEnemigo) {
        this.edificioEnemigo = edificioEnemigo;
    }

    
    
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    
    public boolean isEntrenada() {
        return entrenada;
    }

    public void setEntrenada(boolean entrenada) {
        this.entrenada = entrenada;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getDañoRaza() {
        return dañoRaza;
    }

    public void setDañoRaza(int dañoRaza) {
        this.dañoRaza = dañoRaza;
    }

    public int getVidaRaza() {
        return vidaRaza;
    }

    public void setVidaRaza(int vidaRaza) {
        this.vidaRaza = vidaRaza;
    }

    public int getVelocidadConstruccion() {
        return velocidadConstruccion;
    }

    public void setVelocidadConstruccion(int velocidadConstruccion) {
        this.velocidadConstruccion = velocidadConstruccion;
    }
    
    

    //METODOS
    @Override
    public void AtacarRaza(){
        razaEnemiga.setVidaRaza(razaEnemiga.getVidaRaza()-dañoRaza);
        System.out.println(nombre+" ha hecho "+dañoRaza+" de daño a "+razaEnemiga.getNombre());
        System.out.println("-----------------------------------------------------------------");
    }
    
    @Override
    public void AtacarEdificio(){
        this.setDisponible(false);//
        edificioEnemigo.setVida(edificioEnemigo.getVida()-dañoRaza);
        System.out.println(nombre+" ha hecho "+dañoRaza+" de daño a edificio "+edificioEnemigo.getTipo());
        System.out.println("-----------------------------------------------------------------------");
    }
    
   
}
