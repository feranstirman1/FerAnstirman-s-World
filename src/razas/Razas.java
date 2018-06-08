
package razas;

/**
 *
 * @author feranstirman
 */
public class Razas implements Raza {
    
    private int dañoRaza=50;
    private int vidaRaza=500;
    private int velocidadConstruccion=2;

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
    }
    
    @Override
    public void AtacarEdificio(){
        System.out.println("WIP");
    }
}
