
package razas;

/**
 *
 * @author feranstirman
 */
public class Razas implements Raza {
    
    private int dañoRaza;
    private int vidaRaza;
    private int velocidadConstruccion;

    //GETTERS Y SETTERS
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
        System.out.println("has hecho "+getDañoRaza()+" a la raza enemiga");
    }
    
    @Override
    public void AtacarEdificio(){
        System.out.println("WIP");
    }
}
