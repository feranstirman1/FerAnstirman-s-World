
package razas.dioses;

import razas.Razas;

/**
 *
 * @author feranstirman
 */
public class Zeus extends Dioses{
    
    //CONSTRUCTOR
    public Zeus(){  //SE CREA UN DIOS MAS FUERTE PERO CON MENOS VIDA
        setDañoRaza(getDañoRaza()*2);
        setVidaRaza(getVidaRaza()/4);
    }
    
    //METODOS ESPECIALES DEL ESPECIALISTA
    @Override
    public void AtacarRaza(Razas razaEnemiga){ //ZEUS MUERE INMEDIATAMENTE DESPUES DE ATACAR
        razaEnemiga.setVidaRaza(razaEnemiga.getVidaRaza()-getDañoRaza());
        setVidaRaza(0);
    }
}
