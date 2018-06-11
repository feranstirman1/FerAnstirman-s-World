
package edificios;

/**
 *
 * @author feranstirman
 */
public class BuildingFactory implements AbstractBuilding {
    @Override
    public Edificio getEdificio(String tipo){
        switch(tipo){
            case "centromando":
                return new CentroMando();
            case "recolector de cobre":
                return new EdificioCobre();
            case "recolector de oro":
                return new EdificioOro();
            case "generador de elixir":
                return new EdificioElixir();
            case "edificio de entrenamiento":
                return new EdificioEntrenamiento();
            case "edificio de elefantes":
                return new EdificioElefante();
            case "edificio de panteras":
                return new EdificioPantera();
            default:
                return null;
        }
    }
}
