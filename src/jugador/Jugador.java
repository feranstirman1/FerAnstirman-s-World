
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
        
        
        if(!ExisteEdificioEntrenamiento()){
            System.out.println("No existe ningun edificio de entrenamiento para que la tropa que quiere crear pueda entrenarse");
            System.out.println("Intente crear un edificio de entrenamiento primero");
            System.out.println("----------------------------------------------------------------------");
            return;
        }
        
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
        int cantOro=100;
        int cantElixir=300;
        if(centromando.getElixir().getCantidad()>=cantElixir && centromando.getOro().getCantidad()>=cantOro){
            centromando.getElixir().setCantidad(centromando.getElixir().getCantidad()-cantElixir);
            centromando.getOro().setCantidad(centromando.getOro().getCantidad()-cantOro);
            return true;
        }
        else
            return false;
    }
    
    public void AtacarEdificioEnemigo(){
        
        boolean encontroEdificio=false;
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
                
                int vivos=0;
                for(Edificio e:jugadorEnemigo.getEdificios()){
                    if(e.isVivo()){
                        vivos+=1;
                    }
                }
                
                if(vivos>1){
                    System.out.println("Aun no se puede atacar el centro de mando enemigo porque quedan otros edificios vivos");
                    System.out.println("--------------------------------------------------------------------------------------");
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
            //System.out.println("Edificio enemigo tipo: "+e.getTipo());
            //System.out.println(e.isConstruido());
            //System.out.println(e.isVivo());
            if(e.getTipo().equals(tipo) && e.isConstruido() && e.isVivo()){
                for(Razas r:tropas){
                    if(r.isDisponible()&& r.isEntrenada() && r.EstaVivo()){
                        encontroEdificio=true;
                        System.out.println("Encontro un edificio al cual atacar!");
                        r.setEdificioEnemigo(e);
                        r.AtacarEdificio();
                        if(r.getNombre().equals("Zeus")){ //EL ESPECIALISTA DE LOS DIOSES ATACA UNA VEZ Y MUERE 
                            r.setEstaVivo(false);
                        }
                        return;
                    }
                    
                }
            }
        }
        
        if(!encontroEdificio){
        System.out.println("No hay edificios disponibles para atacar con esa descripcion o sus tropas no estan entrenadas");
        System.out.println("--------------------------------------------");
        }
        
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
                    MostrarEdificiosEnemigos();
                    break;
                case 6:
                    centromando.LevelUp();
                    break;
                case 7:
                    menu.MostrarCostos();
                    break;
                case 8:
                    MostrarEdificios();
                    break;
                case 9:
                    MostrarTropas();
                    break;
                case 10:
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
        while(opcion<1 || opcion>3){
            System.out.println("Escoja una raza valida porfavor");
            opcion=input.nextInt();
        }
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
            r.ActualizarFases(this.getNombre());
            if(r.getVidaRaza()<=0){
                r.setEstaVivo(false);
            }
        }
        
        for(Edificio e:edificios){
            e.ActualizarFases(this.getNombre());
            if(e.getVida()<=0){
                e.setVivo(false);
            }
            
            
            if(e.getTipo().equals("recolector de cobre") && e.isConstruido() && e.isVivo()){ //RECOLECTA COBRE
                centromando.getCobre().setCantidad(centromando.getCobre().getCantidad()+500);
                //System.out.println("se ha recolectado 500 de cobre para "+this.nombre);
                //System.out.println("--------------------------------------------------------------");
            }
            if(e.getTipo().equals("recolector de oro") && e.isConstruido() && e.isVivo()){ //RECOLECTA ORO
                centromando.getOro().setCantidad(centromando.getOro().getCantidad()+100);
                //System.out.println("Se ha recolectado 100 de oro para "+this.nombre);
                //System.out.println("------------------------------------------------------------------");
            }
            if(e.getTipo().equals("generador de elixir") && e.isConstruido() && e.isVivo()){  //RECOLECTA ELIXIR
                centromando.getElixir().setCantidad(centromando.getElixir().getCantidad()+100);
                //System.out.println("Se ha generado 100 de elixir para "+this.nombre);
                //System.out.println("---------------------------------------------------------------------");
            }
            
        }
        
        centromando.ActualizarCentro();
        
        centromando.getCobre().setCantidad(centromando.getCobre().getCantidad()+100);
        
    }
    
    public void MostrarEdificiosEnemigos(){
        System.out.println("-------------------------------------------");
        System.out.println("Edificios Enemigos:");
        int contador=1;
        for(Edificio e:jugadorEnemigo.getEdificios()){
            if(e.isVivo()){
            System.out.println(contador+"."+"Tipo: "+e.getTipo()+" Vida: "+e.getVida());
            contador+=1;
            }
        }
        System.out.println("--------------------------------------------------------------");
    }
    
    public void MostrarEdificios(){
        System.out.println("--------------------------------------------------------");
        System.out.println("******************* MIS EDIFICIOS ************************");
        for(Edificio e:edificios){
            if(e.isVivo() && e.isConstruido()){
                System.out.println("Tipo: "+e.getTipo()+" Vida: "+e.getVida());
            }
        }
        System.out.println("-----------------------------------------------------");
    }
    
    public void MostrarTropas(){
        System.out.println("---------------------------------------------------");
        System.out.println("*********************** MIS GUERREROS *****************");
        for(Razas r:tropas){
            if(r.EstaVivo() && r.isEntrenada() && r.isDisponible()){
                System.out.println("Tipo: "+r.getNombre()+" Vida: "+r.getVidaRaza());
            }
        }
        System.out.println("----------------------------------------------------------");
    }
    
}
