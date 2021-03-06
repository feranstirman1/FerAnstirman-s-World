
package fergame;
import jugador.*;

/**
 *
 * @author feranstirman
 */
public class Juego {
    
    private int fase;
    private boolean gameOver;
    private Jugador jugador1;
    private Jugador jugador2;
    
    public Juego(){
        fase=0;
        gameOver=false;
        System.out.println("GAME START");
        System.out.println("***********************************************");
        jugador1= new Jugador();
        jugador2=new Jugador();
        jugador1.setJugadorEnemigo(jugador2);
        jugador2.setJugadorEnemigo(jugador1);
    }
    
    
    
    public void Run(){
        System.out.println("WELCOME TO FERANSTIRMAN´S WORLD!!!");
        while(!gameOver){ //TODO EL LOOP DEL JUEGO
            System.out.println("FASE: "+fase);
            System.out.println("--------------------------------------------------------------------");
            jugador1.ActualizarObjetos();
            jugador2.ActualizarObjetos();
            jugador1.Jugar();
            jugador2.Jugar();
            CheckIfGameOver();
            fase=fase+1;
        }
        
    }
    
    public void CheckIfGameOver(){
        if(jugador1.getCentromando().getVida()<=0){
            System.out.println(jugador2.getNombre()+" es el ganador!");
            gameOver=true;
        }else if(jugador2.getCentromando().getVida()<=0){
            System.out.println(jugador1.getNombre()+" ha ganado!!");
            gameOver=true;
        }else{
            gameOver=false;
            System.out.println("Se sigue jugando, ha pasado una fase!");
        }
    }
    
}
