
package fergame;
import jugador.*;

/**
 *
 * @author feranstirman
 */
public class Juego {
    
    private boolean gameOver=false;
    private Jugador jugador1;
    private Jugador jugador2;
    
    public void Run(){
        while(!gameOver){ //TODO EL LOOP DEL JUEGO
            jugador1.Jugar();
            jugador2.Jugar();
            CheckIfGameOver();
        }
        
    }
    
    public void CheckIfGameOver(){
        if(jugador1.getCentromando().getVida()==0){
            System.out.println("jugador 2 es el ganador!");
            gameOver=true;
        }else if(jugador2.getCentromando().getVida()==0){
            System.out.println("Jugador 1 ha ganado!!");
            gameOver=true;
        }else{
            gameOver=false;
        }
    }
    
}
