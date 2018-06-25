/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        public ArrayList<Actividad> ordenar() {
            Collections.sort(getListaActividades());
              return getListaActividades();

        }


}


