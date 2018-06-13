
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
    private Menu menu = Menu.getMenu();
    
    private Jugador jugadorEnemigo;

    
    public Jugador(){ //CONSTRUCTOR
        
        Inicializar();
        EscogerNombre();
        EscogerRaza();
        
        
    }



    //GETTER Y SETTER

    public Jugador getJugadorEnemigo() {
        return jugadorEnemigo;
    }

    public void setJugadorEnemigo(Jugador jugadorEnemigo) {
        this.jugadorEnemigo = jugadorEnemigo;
    }
    
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
    
    public void Inicializar(){
        centromando= new CentroMando();
        tropas= new ArrayList<Razas>();
        edificios= new ArrayList<Edificio>();
    }
    
    
    public void CrearTropa(){
        
        
        if(!HayMaterialSuficienteTropas()){
            System.out.println("NO HAY MATERIAL SUFICIENTE PARA CREAR TROPAS");
            System.out.println("-------------------------------------------------");
            return;
        }
        
        
        RazaFactory fabrica;
        Razas nuevaTropa= new Razas();
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
        
        if(!ExisteEdificioEntrenamiento()){
            return;
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
                break;
            default:
                System.out.println("NO SE HA PODIDO CREAR LA NUEVA TROPA");
                break;
        }
        
        if(nuevaTropa!=null){
            tropas.add(nuevaTropa);
            System.out.println("Se ha creado ls nueva tropa con exito");
            System.out.println("----------------------------------------------------------------");
        }else{
            System.out.println("No se ha podido crear a la tropa");
        }
        
    }
    
    public boolean ExisteEdificioEntrenamiento(){
        for(Edificio e:edificios){
            if(e.getTipo().equals("edificio de entrenamiento")){
                return true;
            }
        }
        return false;
    }
    
    public void CrearEdificio(){
        
        if(!HayMaterialSuficienteEdificios()){
            System.out.println("No hay material suficiente para crear el edificio");
            System.out.println("----------------------------------------------------------------");
            return;
        }
        
        
        
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
        
        switch(raza){
            case "mortal":
                nuevoEdificio.setFasesContruir(1);
                break;
            case "mutante":
                nuevoEdificio.setFasesContruir(2);
                break;
            case "dios":
                nuevoEdificio.setFasesContruir(3);
                break;
            default:
                return;
        }
        
        System.out.println("Se ha creado el nuevo edificio con exito");
        System.out.println("-----------------------------------------------------");
        
    }
    
    public boolean HayMaterialSuficienteEdificios(){
        int cantCobre=500;
        int cantOro=250;
        if(centromando.getCobre().getCantidad()>=cantCobre && centromando.getOro().getCantidad()>=cantOro){
            centromando.getCobre().setCantidad(centromando.getCobre().getCantidad()-cantCobre);
            centromando.getOro().setCantidad(centromando.getOro().getCantidad()-cantOro);
            return true;
        }
        else
            return false;
    }
    
    public boolean HayMaterialSuficienteTropas(){
        int cantOro=500;
        int cantElixir=100;
        if(centromando.getElixir().getCantidad()>=cantElixir && centromando.getOro().getCantidad()>=cantOro){
            centromando.getElixir().setCantidad(centromando.getElixir().getCantidad()-cantElixir);
            centromando.getOro().setCantidad(centromando.getOro().getCantidad()-cantOro);
            return true;
        }
        else
            return false;
    }
    
    public void AtacarEdificioEnemigo(){
        
        String tipo;
        int opcion;
        System.out.println("Que tipo de edificio desea atacar?");
        System.out.println("1.Recolector 2.De Entrenamiento 3.De Vehiculos 4.Centro de Mando");
        opcion=input.nextInt();
        switch(opcion){
            case 1:
                int chooser;
                System.out.println("1.De cobre 2.de oro 3.de elixir");
                chooser=input.nextInt();
                switch(chooser){
                    case 1:
                        tipo="recolector de cobre";
                        break;
                    case 2:
                        tipo="recolector de oro";
                        break;
                    case 3:
                        tipo="generador de elixir";
                        break;
                    default:
                        tipo="";
                        System.out.println("opcion no validad");
                        break;
                }
                break;
            case 2:
                tipo="edificio de entrenamiento";
                break;
            case 3:
                tipo="edificio de vehiculos";
                break;
            case 4:
                
                if(!edificios.isEmpty()){
                    System.out.println("Aun no se puede atacar porque quedan otros edificios");
                    System.out.println("-------------------------------------------------------");
                    return;
                }
                
                tipo="centromando";
                break;
            default:
                tipo="";
                System.out.println("OPCION INVALIDA");
                break;
                
        }
       
        for(Edificio e:jugadorEnemigo.getEdificios()){
            if(e.getTipo().equals(tipo) && e.isConstruido() && e.isVivo()){
                for(Razas r:tropas){
                    if(r.isDisponible()&& r.isEntrenada() && r.EstaVivo()){
                        r.setEdificioEnemigo(e);
                        r.AtacarEdificio();
                        return;
                    }
                    
                }
            }
        }
        System.out.println("No hay edificios disponibles para atacar");
        System.out.println("--------------------------------------------");
        
    }
    
    
    
    public void AtacarTropaEnemiga(){
        for(Razas r:jugadorEnemigo.getTropas()){
            if(!r.isDisponible()){
                for(Razas e:tropas){
                    if(e.isDisponible() && e.isEntrenada()&& e.EstaVivo()){
                        e.setRazaEnemiga(r);
                        e.AtacarRaza();
                        return;
                    }
                }
            }
        }
        System.out.println("No hay tropas que lo esten atacando");
        System.out.println("-------------------------------------------");
    }
    
    public void Jugar(){
        boolean turnoOver=false;
        int opcion;
        while(!turnoOver){
            System.out.println("Turno de "+nombre);
            System.out.println("Cobre:"+centromando.getCobre().getCantidad()+" Oro:"+centromando.getOro().getCantidad()+" Elxir:"+centromando.getElixir().getCantidad());
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
                    AtacarEdificioEnemigo();
                    break;
                case 4:
                    AtacarTropaEnemiga();
                    break;
                case 5:
                    turnoOver=true;
                    System.out.println("ha terminado su turno");
                    System.out.println("-----------------------------------------------------");
                    break;
                default:
                    System.out.println("no eligio una opcion valida");
                    break;
            }
        }
    }
    
    public void EscogerRaza(){
        menu.MenuRazas();
        int opcion;
        opcion=input.nextInt();
        switch(opcion){
            case 1:
                raza="mortal";
                break;
            case 2:
                raza="mutante";
                break;
            case 3:
                raza="dios";
                break;
            default:
                System.out.println("No escogio una opcion valida");
                break;
                
        }
        System.out.println("Su raza ha sido elegida. Representa a: "+raza);
        System.out.println("-----------------------------------------------------------------------------");
    }
    
    public void EscogerNombre(){
        System.out.println("Ingrese su user: ");
        nombre=input.nextLine();
        System.out.println("Bienvenido, "+nombre);
    }
    
    public void ActualizarObjetos(){
        
        for(Razas r:tropas){
            r.ActualizarFases();
            if(r.getVidaRaza()<=0){
                r.setEstaVivo(false);
            }
        }
        
        for(Edificio e:edificios){
            e.ActualizarFases();
            if(e.getVida()<=0){
                e.setVivo(false);
            }
            
        }
        
    }
    
}
