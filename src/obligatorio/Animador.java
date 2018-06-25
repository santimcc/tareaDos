/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

public class Animador extends Socio {
    private int aniosXP;
    
    public Animador(){
        this.setAniosXP(0);
    }

    public int getAniosXP() {
        return aniosXP;
    }

    public void setAniosXP(int AniosXP) {
        this.aniosXP = AniosXP;
    }
    

}
