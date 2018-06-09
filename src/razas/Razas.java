
package razas;

/**
 *
 * @author feranstirman
 */
public class Razas implements Raza {
    
    private int dañoRaza;
    private int vidaRaza;
    private int velocidadConstruccion;
    private String nombre;

    
    //GETTERS Y SETTERS
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
    public void AtacarRaza(Razas razaEnemiga){
        razaEnemiga.setVidaRaza(razaEnemiga.getVidaRaza()-dañoRaza);
        System.out.println(nombre+" ha hecho "+dañoRaza+" a "+razaEnemiga.getNombre());
    }
    
    @Override
    public void AtacarEdificio(){
        System.out.println("WIP");
    }
}
