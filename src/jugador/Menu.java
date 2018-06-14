
package jugador;

/**
 *
 * @author feranstirman
 */
public class Menu {
    
    private static Menu menu;
    
    private Menu(){
        
    }
    
    public synchronized static Menu getMenu(){
        if(menu==null){
            menu=new Menu();
        }
        return menu;
    }
    
    public void MostrarMenu(){
        System.out.println("1.Crear Tropa  2.Crear Edificio  3.Atacar Edificio "
                + " 4.Defender Edificio 5.Mostrar Edificios Enemigos 6.Levelear Centro de Mando 7.Mostrar Costos  8.Terminar Turno");
    }
    
    public void MenuRazas(){
        System.out.println("A que raza desea representar?:");
        System.out.println("1.Mortales  2.Mutantes  3.Dioses");
    }
    
    public void MostrarCostos(){
        System.out.println("Milicia  Cobre:500  Oro:250  Elixir:0  ");
        System.out.println("Edificio  Cobre:0  Oro:500  Elixir:100  ");
    }
    
}
