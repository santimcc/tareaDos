package obligatorio;

public class Actividad {
    private String tipo;
    private int horaComienzo;
    private int dia;
    private int costo;
    private int capmax;
    private boolean hayInscriptos;
    private Animador animador;
    
    public boolean getHayInscriptos(){
        return hayInscriptos;
    }
    public void setHayInscriptos(boolean unHayinscriptos){
        hayInscriptos = unHayinscriptos;
    }
    
    //Constructor
    public Actividad() {
        this.setTipo("campo nombre vacio");
        this.setHoraComienzo(9);
        this.setDia(0);
        this.setCosto(0);
        this.setCapmax(0);
        this.setHayInscriptos(false);
        //Falta posible constructor de Animador
        
    }
    
    public String getTipo(){
        return tipo;
    }
    public int getHoraComienzo(){
        return horaComienzo;
    }
    public int getDia(){
        return dia;
    }    
    public int getCosto(){
        return costo;
    }
    public int getCapmax(){
        return capmax;
    }
    public Animador getAnimador(){
        return animador;
    }
    
    public void setTipo(String unTipo){
        tipo = unTipo;
    }
    public void setHoraComienzo(int unaHoraComienzo){
        horaComienzo = unaHoraComienzo;
    }
    public void setDia(int unDia){
        dia = unDia;
    }
    public void setCosto(int unCosto){
        costo = unCosto;
    }
    public void setCapmax(int unaCapmax){
        capmax = unaCapmax;
    }
    public void setAnimador (Animador unAnimador){
        animador=unAnimador;
    }
    
    
    @Override
    public String toString(){
        return " Tipo de actividad: " 
                + this.getTipo() 
                + "\n hora de comienzo: " 
                + this.getHoraComienzo() 
                + "\n día: " 
                + this.getDia() 
                + "\n costo: $" 
                + this.getCosto() 
                + "\n capacidad máxima: " 
                + this.getCapmax() 
                + "\n Animador a cargo: "
                + this.getAnimador()
                + "\n -----------------------------------------";
                
    }
    
}