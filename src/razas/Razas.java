
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
    private boolean disponible=true;
    private boolean estaVivo=true;
    
    
    private Razas razaEnemiga;         //ATRIBUTOS PARA ATACAR AL ENEMIGO
    private Edificio edificioEnemigo;
    
    
    private int fasesNecesariasEntrenada=2;
    private int fasesNecesariasAtacar=4;
    

        //GETTERS Y SETTERS

    public boolean EstaVivo() {
        return estaVivo;
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    
    public int getFasesNecesariasEntrenada() {
        return fasesNecesariasEntrenada;
    }

    public void setFasesNecesariasEntrenada(int fasesNecesariasEntrenada) {
        this.fasesNecesariasEntrenada = fasesNecesariasEntrenada;
    }

    public int getFasesNecesariasAtacar() {
        return fasesNecesariasAtacar;
    }

    public void setFasesNecesariasAtacar(int fasesNecesariasAtacar) {
        this.fasesNecesariasAtacar = fasesNecesariasAtacar;
    }

    
    
    
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
        this.setDisponible(false);
        
        if(fasesNecesariasAtacar>0){
            System.out.println("Debe esperar para poder atacar");
            System.out.println("--------------------------------------------------");
            return;
        }
        
        razaEnemiga.setVidaRaza(razaEnemiga.getVidaRaza()-dañoRaza);
        System.out.println(nombre+" ha hecho "+dañoRaza+" de daño a "+razaEnemiga.getNombre());
        System.out.println("-----------------------------------------------------------------");
        
        if(razaEnemiga.getVidaRaza()<=0){
            razaEnemiga=null;
        }
        
    }
    
    @Override
    public void AtacarEdificio(){
        this.setDisponible(false);
        
        if(fasesNecesariasAtacar>0){
            System.out.println("Debe esperar para poder atacar");
            System.out.println("-------------------------------------------------------------");
            return;
        }
        
        if(!edificioEnemigo.isConstruido()){
            System.out.println("El edificio que quiere atacar aun no ha terminado de construirse");
            return;
        }
        
        edificioEnemigo.setVida(edificioEnemigo.getVida()-dañoRaza);
        System.out.println(nombre+" ha hecho "+dañoRaza+" de daño a edificio "+edificioEnemigo.getTipo());
        System.out.println("-----------------------------------------------------------------------");
        
        if(edificioEnemigo.getVida()<=0){
            edificioEnemigo=null;
        }
        
    }
    
    public void ActualizarFases(String nombre){
        
        fasesNecesariasEntrenada-=1;
        
        if(!disponible){
            fasesNecesariasAtacar-=1;
        }
        
        if(fasesNecesariasEntrenada==0){
            entrenada=true;
            System.out.println(nombre+" tiene una nueva tropa entrenada y lista para atacar");
            System.out.println("-----------------------------------------------------");
        }
        if(fasesNecesariasAtacar<=0 && entrenada && !disponible){
            if(razaEnemiga==null && edificioEnemigo!=null){
                AtacarEdificio();
            }else if(edificioEnemigo==null && razaEnemiga!=null){
                AtacarRaza();
            }else{
                System.out.println("la tropas de "+nombre+" han regresado a la base con vida");
                disponible=true;
            }
        }
        
    }
    
   
}
