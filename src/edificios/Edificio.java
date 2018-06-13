
package edificios;

/**
 *
 * @author feranstirman
 */
public class Edificio {
    
    private int vida;
    private String tipo;
    private boolean construido=false;
    private boolean vivo=true;
    private int fasesContruir;

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    
    public boolean isConstruido() {
        return construido;
    }

    public void setConstruido(boolean construido) {
        this.construido = construido;
    }

    public int getFasesContruir() {
        return fasesContruir;
    }

    public void setFasesContruir(int fasesContruir) {
        this.fasesContruir = fasesContruir;
    }
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public void ActualizarFases(String nombre){
        fasesContruir-=1;
        if(fasesContruir<=0 && !construido){
            construido=true;
            System.out.println("El edificio que "+nombre+ " creo ya esta construido y listo para funcionar!!!");
            System.out.println("-------------------------------------------------------------------");
        }
    }
    
    
}
