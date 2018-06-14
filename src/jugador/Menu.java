
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
                + " 4.Defender 5.Edificios Enemigos 6.Levelear Centro de Mando 7.Mostrar Costos 8.Mis Edificios 9.Mis Tropas 10.Terminar Turno");
    }
    
    public void MenuRazas(){
        System.out.println("A que raza desea representar?:");
        System.out.println("1.Mortales  2.Mutantes  3.Dioses");
    }
    
    public void MostrarCostos(){
        System.out.println("---------------------------------------------------");
        System.out.println("*************COSTOS**********************************");
        System.out.println("Edificio  Cobre:500  Oro:250  Elixir:0  ");
        System.out.println("Guerrero  Cobre:0  Oro:500  Elixir:100  ");
        System.out.println("-----------------------------------------------------");
    }
    
}
