
package obligatorio;

public class Animador extends Socio {
    private int aniosXP;
    private boolean asignadoAct;

    public Animador(){
        this.setAniosXP(0);
        this.setAsignadoAct(false);
    }
    
    public boolean getAsignadoAct() {
        return asignadoAct;
    }

    public void setAsignadoAct(boolean asignadoAct) {
        this.asignadoAct = asignadoAct;
    }   

    public int getAniosXP() {
        return aniosXP;
    }

    public void setAniosXP(int AniosXP) {
        this.aniosXP = AniosXP;
    }
    
    @Override
    public String toString(){
        return " Nombre: "
                + this.getNombre() 
                + "\n     Documento del animador: " 
                + this.getDocumento() 
                + "\n     años de Experiencia: " 
                + this.getAniosXP() 
                + "\n -----------------------------------------";
    }

}
