
package jugador;
import razas.*;
import razas.dioses.*;
import razas.mortales.*;
import razas.mutantes.*;
import java.util.ArrayList;
import edificios.*;
import java.util.Scanner;
        
/**
 *
 * @author feranstirman
 */
public class Jugador {
    
    Scanner input=new Scanner(System.in);
    private String nombre;
    private String raza;
    private CentroMando centromando;
    private ArrayList<Razas> tropas;
    private ArrayList<Edificio> edificios;
    private boolean turnoOver;
    private Menu menu = Menu.getMenu();

    //GETTER Y SETTER
    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public CentroMando getCentromando() {
        return centromando;
    }

    public void setCentromando(CentroMando centromando) {
        this.centromando = centromando;
    }

    public ArrayList<Razas> getTropas() {
        return tropas;
    }

    public void setTropas(ArrayList<Razas> tropas) {
        this.tropas = tropas;
    }

    public ArrayList<Edificio> getEdificios() {
        return edificios;
    }

    public void setEdificios(ArrayList<Edificio> edificios) {
        this.edificios = edificios;
    }
    
    
    //METODOS
    public void CrearTropa(){
        RazaFactory fabrica;
        Razas nuevaTropa;
        System.out.println("1.Tropa  2.Especialista");
        int opcion = input.nextInt();
        String tipo;
        switch(opcion){
            case 1:
                tipo="ejercito";
                break;
            case 2:
                tipo="especialista";
                break;
            default:
                tipo="ejercito"; //SI SE DA UN VALOR ERRONEO AUTOMATICAMENTE CREA UN EJERCITO
                break;
        }
        switch(raza){
            case "dios":
                fabrica= new GodFactory();
                nuevaTropa = fabrica.getDios(tipo);
                break;
            case "mutante":
                fabrica = new MutantFactory();
                nuevaTropa=fabrica.getMutante(tipo);
                break;
            case "mortal":
                fabrica=new MortalFactory();
                nuevaTropa=fabrica.getMortal(tipo);
            default:
                System.out.println("NO SE HA PODIDO CREAR LA NUEVA TROPA");
                nuevaTropa= null;
        }
        
        tropas.add(nuevaTropa);
        
    }
    public void CrearEdificio(){
        Edificio nuevoEdificio;
        BuildingFactory fabrica=new BuildingFactory();
        String tipoEdificio;
        int opcion;
        System.out.println("1.Edificio de Materiales  2.Edificio de Entrenamiento  3.Edificio de Vehiculos");
        opcion=input.nextInt();
        switch(opcion){
            case 1:
                String material;
                int chooser;
                System.out.println("Que tipo de material generara el edificio");
                System.out.println("1.Cobre  2.Oro  3.Elixir");
                chooser=input.nextInt();
                switch(chooser){
                    case 1:
                        tipoEdificio="recolector de cobre";
                        break;
                    case 2:
                        tipoEdificio="recolector de oro";
                        break;
                    case 3:
                        tipoEdificio="generador de elixir";
                        break;
                    default:
                        tipoEdificio="";
                        break;
                }
                nuevoEdificio= fabrica.getEdificio(tipoEdificio);
                break;
            case 2:
                nuevoEdificio= fabrica.getEdificio("edificio de entrenamiento");
                break;
            case 3:
                String vehiculo;
                int opcionVehiculo;
                System.out.println("Que vehiculo desea crear");
                System.out.println("1.Elefante  2.Pantera");
                opcionVehiculo=input.nextInt();
                switch(opcionVehiculo){
                    case 1:
                        vehiculo="edificio de elefantes";
                        break;
                    case 2:
                        vehiculo="edificio de panteras";
                        break;
                    default:
                        vehiculo="";
                        break;
                }
                nuevoEdificio= fabrica.getEdificio(vehiculo);
                break;
            default:
                nuevoEdificio=null;
                
        }
        
        edificios.add(nuevoEdificio);
        
    }
    
    public void AtacarEdificio(){
        
    }
    
    public void AtacarTropa(){
        
    }
    
    public void Jugar(){
        int opcion;
        while(!turnoOver){
            menu.MostrarMenu();
            opcion=input.nextInt();
            switch(opcion){
                case 1:
                    CrearTropa();
                    break;
                case 2:
                    CrearEdificio();
                    break;
                case 3:
                    AtacarEdificio();
                    break;
                case 4:
                    AtacarTropa();
                    break;
                case 5:
                    turnoOver=true;
                default:
                    System.out.println("no eligio una opcion valida");
                    break;
            }
        }
    }
    
}
