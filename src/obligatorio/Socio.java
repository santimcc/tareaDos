package obligatorio;

public class Socio {
    private String nombre;
    private String documento;
    private int edad;
    private String direccion;
    
    //Constructor
    public Socio() {  
        this.setNombre("Campo nombre: vacio ");
        this.setEdad(0);
        this.setDireccion("Campo dirección: vacio");
        this.setDocumento("Campo documento: vacio");
    }
	 
 
  
    public String getNombre(){
        return nombre;
    }
    public String getDocumento(){
        return documento;
    }
    public int getEdad(){
        return edad;
    }    
    public String getDireccion(){
        return direccion;
    }
    
    public void setNombre(String unNombre){
        nombre = unNombre;
    }
    public void setDocumento(String unDocumento){
        documento = unDocumento;
    }
    public void setEdad(int unaEdad){
        edad = unaEdad;
    }
    public void setDireccion(String unaDireccion){
        direccion = unaDireccion;
    }
    
    
    @Override
    public String toString(){
        return " Nombre: "
                + this.getNombre() 
                + "\n   Documento: " 
                + this.getDocumento() 
                + "\n   Edad: " 
                + this.getEdad() 
                + "\n   Direccion: " + this.getDireccion() 
                + "\n -----------------------------------------"; // 
    }    
}