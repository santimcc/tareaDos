package obligatorio;

public class Inscripcion {
    private Socio socio;
    private Actividad actividad;
    private String telefono;
    private int horaRecoger;

    public Inscripcion(Socio unSocio, Actividad unaActividad, 
                        String unTelefono, int unahoraRecoger) {
        this.setSocio(unSocio);
        this.setActividad(unaActividad);
        this.setTelefono(unTelefono);
        this.setHoraRecoger(unahoraRecoger);
    }
    public boolean VerificarHora(){   /*devuelve true cuando la hora de  
                         recoger es por lo menos 1 hora antes que el comienzo*/
        return (((actividad.getHoraComienzo()) -1) >= (horaRecoger));        
    } 
   
    
    public Socio getSocio(){
        return socio;
    }
    public Actividad getActividad(){
        return actividad;
    }
    public String getTelefono(){
        return telefono;
    }    
    public int getHoraRecoger(){
        return horaRecoger;
    }
  
    public void setSocio(Socio unSocio){
        socio = unSocio;
    }
    public void setActividad(Actividad unaActividad){
        actividad = unaActividad;
    }
    public void setTelefono(String unTelefono){
        telefono = unTelefono;
    }
    public void setHoraRecoger(int unaHoraRecoger){
        horaRecoger = unaHoraRecoger;
    }
   
    @Override
    public String toString(){
        return ("\n Inscripción del socio: "
                + this.socio.getNombre()
                + "\n   A la actividad: "
                + this.actividad.getTipo() 
                + "     El día " 
                + this.actividad.getDia() 
                + "     Que comienza a las " 
                + this.actividad.getHoraComienzo()
                + "\n   Teléfono del inscripto: " 
                + this.getTelefono() 
                + "\n   Hora de pasar a buscarlo: " + this.getHoraRecoger() 
                +  "\n -----------------------------------------");
    }
}