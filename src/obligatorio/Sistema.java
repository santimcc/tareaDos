package obligatorio;

import java.util.*;

public class Sistema {

private ArrayList <Socio> listaSocios;
private ArrayList <Animador> listaAnimadores;
private ArrayList <Inscripcion> listaInscripciones;
private ArrayList <Actividad> listaActividades;

    public Sistema(){
        listaSocios = new ArrayList<Socio>();
        listaAnimadores = new ArrayList<Animador>();
        listaInscripciones = new ArrayList<Inscripcion>();
        listaActividades = new ArrayList<Actividad>();
    }
        public ArrayList<Socio> getListaSocios(){
            return listaSocios;
        }
        public ArrayList<Animador> getListaAnimadores(){
            return listaAnimadores;
        }
        public ArrayList<Inscripcion> getListaInscripciones(){ 
            return listaInscripciones;
        }
        public ArrayList<Actividad> getListaActividades(){
            return listaActividades;
        }
        public void agregarSocio(Socio unSocio){
            listaSocios.add(unSocio);
        }
        public void agregarAnimador(Animador unAnimador){
            listaAnimadores.add(unAnimador);  
        }
        public void agregarInscripcion(Inscripcion unaInscripcion){
            listaInscripciones.add(unaInscripcion);
        }
        public void agregarActividad(Actividad unaActividad){
            listaActividades.add(unaActividad);
        }
        
        public ArrayList<Actividad> ordenar() { //ordenar lista de actividades
            Collections.sort(this.getListaActividades());
            return getListaActividades();
        }
        
        public ArrayList<Inscripcion> ordenarInscripciones(){
            Collections.sort(this.getListaInscripciones());
            return getListaInscripciones();
        }
        
        public void mostrarLista(ArrayList lista) {//para imprimir una lista
            Iterator<Object> it = lista.iterator();
            int i = 1;
            while(it.hasNext()){
                System.out.println (i + " - " + it.next());
                i++;
            }
        
        }
         
        public void borrarInscripciones (Actividad actividad){
            ordenarInscripciones();
            Iterator<Inscripcion> it = this.getListaInscripciones().iterator();
            //recorrer la lista de inscripciones
            for (int i = 0; i < getListaInscripciones().size(); i++) {                
                if (listaInscripciones.get(i).getActividad() == actividad){
                    //si es la actividad que busco
                    //entonces muestra el nobmre del socio y su telefono.
                    System.out.println("telefono del socio " 
                            +listaInscripciones.get(i).getSocio().getNombre() 
                            + " " 
                            +listaInscripciones.get(i).getTelefono());    
                }                
            }
            while (it.hasNext()){
                if (it.next().getActividad() == (actividad)){                    
                    it.remove(); //elimina la inscripcion
                }
            }
        }
        

}


