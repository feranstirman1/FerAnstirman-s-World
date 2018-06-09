
package razas.mortales;

/**
 *
 * @author feranstirman
 */
public class SuperSoldier extends Mortal {
    
    //CONSTRUCTOR
    public SuperSoldier(){  //SE CREA UN MORTAL MAS FUERTE Y CON LA MISMA VIDA
        this.setVidaRaza(1000);
        this.setDañoRaza(200);
        this.setNombre("Super Soldado");
    }
}
