package obligatorio;
import java.util.*;
//Marco Liguori y Santiago Mc Clew
//prueba de cambio
//pbrueba de cambio 2
//prueba 3



//prueba/
//de nueva brunch
public class Prueba extends Sistema  {
	
	
    

    public static Socio crearSocio(){ //crea un nuevo socio y pide los datos de cada socio cada vez que se invoca
        Socio nuevoSocio = new Socio(); //crea un nuevo objeto Socio
        
        System.out.print("Ingresar nombre del socio: ");
        nuevoSocio.setNombre(pedirString());
        
        System.out.print("Ingresar documento: ");
        nuevoSocio.setDocumento(pedirString());

        System.out.print("Ingresar edad: ");
        nuevoSocio.setEdad(DatoValido(50,130));

        System.out.print("Ingresar direcciÃ³n: ");
        nuevoSocio.setDireccion(pedirString());

        System.out.println("");
        return (nuevoSocio); //devuelve un nuevo socio con sus datos correspondientes ya ingresados.
    }  // fin metodo crear socio
    
    public static Socio testcrearSocio(){
        Socio ns = new Socio();
        System.out.print("ingresar nombre de socio de prueba: ");
        ns.setNombre(pedirString());
        ns.setDocumento("doc prueba Socio");
        ns.setEdad(66);
        ns.setDireccion("direccion prueba socio");
        System.out.println("socio de prueba creado");
        System.out.println("");
        return (ns);
    }
    
    public static Animador crearAnimador(){ //crea un nuevo socio y pide los datos de cada socio cada vez que se invoca
        Animador nuevoAnimador = new Animador(); //crea un nuevo objeto animador
        
        System.out.print("Ingresar nombre del animador: ");
        nuevoAnimador.setNombre(pedirString());
        
        System.out.print("Ingresar documento: ");
        nuevoAnimador.setDocumento(pedirString());

        /*System.out.print("Ingresar edad: ");
        nuevoAnimador.setEdad(DatoValido(18,130));
        
        System.out.print("Ingresar direcciÃ³n: ");
        nuevoAnimador.setDireccion(pedirString());*/
        
        System.out.println("Ingrese los anos de experiencia del animador");
        nuevoAnimador.setAniosXP(DatoValido(1,65));
        
        System.out.println("");
        return (nuevoAnimador); //devuelve un nuevo socio con sus datos correspondientes ya ingresados.
    }  // fin metodo crear socio
    
    public static Animador testcrearAnimador(){
        Animador nuevoAnimador = new Animador();
        nuevoAnimador.setNombre("nombre animador prueba");
        nuevoAnimador.setDocumento("documento prueba animador");
        nuevoAnimador.setEdad(22);
        nuevoAnimador.setDireccion("dir prueba animador");
        nuevoAnimador.setAniosXP(3);
        System.out.println("animador de prueba creado");
        System.out.println("");
        return(nuevoAnimador);
    }
    
    public static Inscripcion crearInscripcion(Socio datosSocio, Actividad datosActividad){  
        datosActividad.setHayInscriptos(true);
        
        System.out.print("Ingresar telÃ©fono: ");
        String tel = pedirString();
        System.out.print("Ingresar hora de pasar a buscar al socio: ");
        int hora = DatoValido(6,20);    
        Inscripcion nuevaInscripcion = new Inscripcion(datosSocio, datosActividad, tel, hora);
        
        while (! nuevaInscripcion.VerificarHora()){
            System.out.print("Hora de pasar a buscar al socio debe ser por lo menos una hora antes del inicio de la actividad,"
                    + " La actividad comienza a las " + datosActividad.getHoraComienzo()
                    + "\n Ingrese hora nueva: ");
            nuevaInscripcion.setHoraRecoger(DatoValido(6,20));
        }        
        return (nuevaInscripcion);        
    } //fin crear inscripcion
    
    public static Inscripcion testcrearInscripcion(Socio datosSocio, Actividad datosActividad){
        datosActividad.setHayInscriptos(true);
        System.out.print("tel: ");
        String tel = pedirString();
        int hora = 7;
        Inscripcion nuevaInscripcion = new Inscripcion(datosSocio, datosActividad, tel, hora);
        System.out.println("inscripcion de prueba creada");
        System.out.println("");
        return(nuevaInscripcion);
    
    }
    
    public static Actividad testCrearActividad(Sistema empresa){
        Actividad na = new Actividad();
        
        na.setDia(2);
        System.out.print("tipo actividad del 1 al 7: ");
        na.setTipoEntero(DatoValido(1,7));
        System.out.print("tipo en string: ");
        na.setTipo(pedirString());
        na.setHoraComienzo(7);
        na.setCapmax(2);
        na.setCosto(0);
       // na.setHayInscriptos(true);
        na.setAnimador(empresa.getListaAnimadores().get(0));
        
        System.out.println("actividad de prueba creada");
        System.out.println("");
        return(na);
    }
    
    public static Actividad crearActividad(Sistema empresa){  //metodo para crear un nuevo objeto tipo actividad, pide los datos para llenar cada vez que se invoca
        Actividad nuevaActividad = new Actividad(); // se crea el nuevo objeto
       
        
        //a continuacion se pediran los datos necesarios y su validacion para que se rellene correctamente los datos de la actividad.        
        System.out.print("Ingresar dia de la actividad entre el 1 y el 31: "); // se pide ingreso del dia de la actividad
        nuevaActividad.setDia(DatoValido(1,31));
        
        System.out.println("Elegir tipo de actividad: "); // despliega el menu de opciones de tipo de actividad.
        System.out.println("    1- Teatro");
        System.out.println("    2- Cine");
        System.out.println("    3- Viaje");
        System.out.println("    4- Paseo local");
        System.out.println("    5- Paseo interdepartamental");
        System.out.println("    6- Caminata");
        System.out.println("    7- Otro");
        
        System.out.print("Tipo de actividad: ");    
        int opcion = DatoValido(1,7);        // lee el dato.
        
        nuevaActividad.setTipoEntero(opcion); //guarda el tipo de actividad en un entero

        switch (opcion) {           // segun opcion elegida le da su correspondiente nombre.            
            case 1:
                nuevaActividad.setTipo("1 Teatro");
                System.out.println("EligiÃ³ teatro como tipo de actividad.");
                break;
            case 2:
                nuevaActividad.setTipo("2 Cine");
                System.out.println("EligiÃ³ cine como tipo de actividad.");
                break;
            case 3:
                nuevaActividad.setTipo("3 Viaje");
                System.out.println("EligiÃ³ viaje como tipo de actividad.");
                break;
            case 4:
                nuevaActividad.setTipo("4 Paseo local");
                System.out.println("EligiÃ³ paseo local como tipo de actividad.");
                break;
            case 5:
                nuevaActividad.setTipo("5 Paseo interdepartamental");
                System.out.println("EligiÃ³ paseo interdepartamental como tipo de actividad.");
                break;
            case 6:
                nuevaActividad.setTipo("6 Caminata");
                System.out.println("EligiÃ³ caminata como tipo de actividad.");
                break;
            case 7:
                nuevaActividad.setTipo("7 Otro");
                System.out.println("EligiÃ³ otro tipo de actividad.");
                break;
        }//fin switch elegir tipo de actividad
  
        
        System.out.print("Ingresar hora de comienzo de la actividad entre las 7 y las 21: ");   //pide hora de comienzo de actividad y verifico que sea correcta
        nuevaActividad.setHoraComienzo(DatoValido(7,21));        
        
        
        System.out.print("Ingresar capacidad mÃ¡xima: ");  // pido ingresar capacidad de la actividad
        nuevaActividad.setCapmax(DatoValido(1,Integer.MAX_VALUE));
        
        System.out.print("Ingresar costo de la actividad: $"); //pido ingresar costo
        nuevaActividad.setCosto(DatoValido(0,Integer.MAX_VALUE));
        
        nuevaActividad.setAnimador((Animador) seleccionarDeLista(empresa.getListaAnimadores(), "elija un animador:"));
        nuevaActividad.getAnimador().setAsignadoAct(true);
        
        /*
        System.out.println("Ingresar animador a cargo");//pido inggresar animador a cargo
        System.out.println("animadores disponibles: ");
        empresa.mostrarLista(empresa.getListaAnimadores()); /////////////////////preguntar si empresa se pasa por parametro
        System.out.println("Elija uno: ");
        int eleccion = DatoValido(1, empresa.getListaAnimadores().size()) - 1;
        nuevaActividad.setAnimador(empresa.getListaAnimadores().get(eleccion));*/
        
        return (nuevaActividad);  //devuelve un Nuevo objeto de tipo Actividad con datos ingresados. 
        
    }//fin metodo de crear nueva actividad
    
    public static int DatoValido(int min, int max){  //MÃ©todo que pide un dato y lo verifica entre dos valores a seleccionar.
        Scanner in = new Scanner (System.in);
        int num = 0 ;
        boolean ok = false;
        while (!ok){
            try{
                num = in.nextInt();
                while (! ((num >= min) && (num <= max))){ 
                    System.out.print("Dato ingresado no es correcto,"
                            + "\nIngrese un valor entre " + min + " y " + max + ": ");
                    num = in.nextInt();
                }
              ok = true;
            }//try
            
            catch (InputMismatchException e){
                System.out.println("Error, ingresar numeros.");
                in.nextLine();
            }
            
        }
    return (num); 
    }   
	
    public static String pedirString(){ //MÃ©todo para pedir String y no crear Scanner en cada mÃ©todo
        Scanner in = new Scanner (System.in);
        String dato = in.nextLine();
        return dato;
    }
  
    public static void modificarSocio(Socio socioMod){ //MÃ©todo para modificar direcciÃ³n y edad de un socio
        
        System.out.println("Se modificarÃ¡n los datos del socio " + socioMod.getNombre());
        System.out.println("DirecciÃ³n actual: " + socioMod.getDireccion());
        System.out.print("Ingrese nueva direcciÃ³n del socio: ");
        socioMod.setDireccion(pedirString());  //se modifica la direccion del socio indicado
        
        System.out.println("Edad actual: " + socioMod.getEdad());
        System.out.print("Ingrese nueva edad del socio ");        
        socioMod.setEdad(DatoValido(50,130)); //se modifica la edad del socio
    }  // fin metodo de modificar socio
        
    public static boolean esTemprana(Inscripcion ins, Actividad act){
        return ((act.getHoraComienzo() - ins.getHoraRecoger()) >= 3);
    }
    
    public static Object seleccionarDeLista (ArrayList<?> lista, String mensaje){//el <?> significa que es de cualquier tipo
        System.out.println(mensaje);
        for (int i = 0 ; i < lista.size(); i++){
            System.out.println((i + 1) + " - " + lista.get(i));
        }
        System.out.print("seleccione una opcion: ");
        int seleccion = DatoValido(1, lista.size());
        return lista.get(seleccion - 1);
    }
    
    public static void tipoEnteroAString(int tipo){ //Para imprimir el tipo de actividad favorita en string
        switch (tipo) {           
            case 1:
                System.out.print("tipo 1: Teatro");
                break;
            case 2:
                System.out.print("tipo 2: cine");
                break;
            case 3:
                System.out.print("tipo 3: viaje");
                break;
            case 4:
                System.out.print("tipo 4: paseo local");
                break;
            case 5:
                System.out.print("tipo 5: paseo interdepartamental");
                break;
            case 6:
                System.out.print("tipo 6: caminata");
                break;
            case 7:
                System.out.print("tipo 7: otro");
                break;
        }
    }
    
    public static void mostrarOpciones(){ // metodo para desplegar el menu principal
        System.out.println(  ""
                         + "\n            MENu PRINCIPAL                             "
                         + ""
                         + "\nSeleccione una tarea a realizar:                       "
                         + "\n                                                       "
                         + "\n  1- socio                   "
                         + "\n  2- animador                          "
                         + "\n  3- actividad          "
                         + "\n  4- inscripcion.            "
                         + "\n  5- asteriscos.                                      "
                         + "\n  6- lista ordenada.                                              "
                         + "\n  7- eliminar actividad"
                         + "\n  8- actividades favoritas"
                         + "\n  9- animadores sin actividad"
                         + "\n  10- salir"
                         + "");
    }
    
    /*-----------------------------------------------------------------------------------*/
    /*--------------------------------------MAIN-----------------------------------------*/
    /*-----------------------------------------------------------------------------------*/
    
    public static void main(String[] args) {
        Sistema empresa = new Sistema();
        //ArrayList<Animador>();
        
        
        
        mostrarOpciones();
        System.out.print("Ingresar opcion: ");
        int opcion = DatoValido(1,10);
        
        while (opcion != 10){ //pedir que se ingrese opcion del menu hasta que sea = a 6 y termine el programa
            switch (opcion){
                case 1: 
                    System.out.println("Eligio opcion 1: Agregar un socio");
                    empresa.agregarSocio(crearSocio());
                    //empresa.agregarSocio(testcrearSocio());
                    
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                    break;
            
     
                case 2:
                    System.out.println("Eligio opcion 2: Agregar nuevo animador");
                    empresa.agregarAnimador(crearAnimador());
                    //empresa.agregarAnimador(testcrearAnimador());
                    
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                    break; 
                    
                    
                case 3:
                    System.out.println("Eligio opcion 3: Crear una actividad");
                  if(! empresa.getListaAnimadores().isEmpty()){
                      empresa.agregarActividad(crearActividad(empresa));
                      //empresa.agregarActividad(testCrearActividad(empresa));
                      
                  }
                  else{
                      System.out.println("No se puede crear una actividad sin animadores");
                  }
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                    break;
                   
                case 4:
                    System.out.println("Eligio opcion 4: Crear una inscripcion");
                    if(! empresa.getListaActividades().isEmpty() && ! empresa.getListaSocios().isEmpty()){
                        Actividad activ = (Actividad) seleccionarDeLista(empresa.getListaActividades(), "Actividades disponibles: ");
                        Socio socio = (Socio) seleccionarDeLista(empresa.getListaSocios(), "Socios disponibles: ");
                        
                        if (activ.getCapmax() != 0){
                            empresa.agregarInscripcion(crearInscripcion(socio, activ));
                            //empresa.agregarInscripcion(testcrearInscripcion(socio, activ));

                            activ.setCapmax(activ.getCapmax()-1);
                        }
                        else{
                            System.out.println("no hay mas cupos para esa actividad.");
                           
                        }
                        
                    }
                    else{
                                System.out.println("No se puede crear una inscripcion sin socios y actividades");
                                }
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                    break;
            
                case 5:
                    System.out.println("Eligio opcion 5: Mostrar Grafica");
                    if(! empresa.getListaActividades().isEmpty()){
                        System.out.print("Ingrese un dia: ");
                        int diaP = DatoValido(1,31);
                        int [] tipos = new int [7];
                        for (int i = 0; i < empresa.getListaActividades().size(); i++) {
                            if(empresa.getListaActividades().get(i).getDia()==diaP){
                                tipos[empresa.getListaActividades().get(i).getTipoEntero()]++;
                            }
                        }

                        for (int i = 1; i < tipos.length; i++) {
                            if(tipos[i]>0){
                                System.out.print("  " + i +" - ");
                                for (int j = 1; j <= tipos[i] ; j++) {
                                    System.out.print("*");

                                }
                                System.out.println("");
                            }
                        }
                    }//del if
                    else{
                        System.out.println("no hay actividades registradas");
                    }

                    pedirString();
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                   
                    break;
                    
                case 6:
                    System.out.println("Listado de actividades por fecha/tipo");
                                                          
                    if (! empresa.getListaActividades().isEmpty()){
                        empresa.ordenar();
                        empresa.mostrarLista(empresa.getListaActividades());
                    }
                    else{
                        System.out.println("no hay actividades registradas");
                    }
                
                    pedirString();
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                    break;
                    
                case 7:
                    System.out.println("Eligio opcion 7: Dar de baja una actividad"); 
                    
                    if (! empresa.getListaActividades().isEmpty()){
                        Actividad aBorrar = (Actividad) seleccionarDeLista(empresa.getListaActividades(), "Elija actividad a borrar");//muestra la lista y se elije una actividad a borrar
                        empresa.borrarInscripciones(aBorrar); //borra ins
                        aBorrar.getAnimador().setAsignadoAct(false);

                        empresa.getListaActividades().remove(aBorrar);
                        
                        System.out.println("");
                        System.out.println("se borro la actividad elegida y se desplegaron los telefonos de inscriptos");
                    }
                    else{ 
                        System.out.println("no hay actividades registradas.");
                    }
                    
                    
                    pedirString();
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                    break;
                    
                case 8:
                    System.out.println("opcion 8, actividades preferidas");
                    if (! empresa.getListaActividades().isEmpty()){
                        int actPreferidas [] = new int [7];  //creo array de 8 espacios, el espacio 0 no se usa
                        /*for (int i = 0; i < actPreferidas.length; i++) {
                        actPreferidas[i] = 0;  //lleno el array con ceros

                        }
                        System.out.println("array en cero:");
                        for (int i = 0; i < actPreferidas.length; i++) {
                            System.out.print(actPreferidas[i] + " - "); //imprimo el array lleno de ceros

                        }
                        System.out.println("");*/

                        for (int i = 0; i < empresa.getListaInscripciones().size(); i++) {
                            actPreferidas[empresa.getListaInscripciones().get(i).getActividad().getTipoEntero()]++; //lleno el array con cantidad de actividaes
                        }

                        int max = actPreferidas[1]; //defino el maximo como el primer valor para luego comparar.

                        //System.out.println("max antes del for " + max);

                        for (int i = 2; i < actPreferidas.length; i++) {  //busco el max en el array

                            if(max<actPreferidas[i]){
                                max = actPreferidas[i];
                            }
                        }

                        //System.out.println("max DESPUES del for " + max);

                        /*System.out.println("array lleno");
                        for (int j = 0; j < actPreferidas.length; j++) {
                        System.out.print(actPreferidas[j] + " - "); //imprimo el array

                        }*/

                        System.out.println("");


                        for (int i = 1; i < actPreferidas.length; i++) {
                            if(actPreferidas[i] == max){
                                System.out.println("Actividades preferidas: " ); 
                                tipoEnteroAString(i);                          //imprimo los valores del array que son iguales al maximo
                                System.out.print(", con " + max + " inscripciones ");
                                //System.out.println(actPreferidas[i]);
                            }

                        }
                    }
                    else{
                        System.out.println("no hay actividades registradas");
                    }
    
                    System.out.println("");
                    pedirString();
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                    break;
                    
                case 9:
                    System.out.println("EligiÃ³ opciÃ³n 9: animadores sin actividad");
                    if (! empresa.getListaAnimadores().isEmpty()){
                        for (int i = 0; i < empresa.getListaAnimadores().size(); i++) {
                            if (! empresa.getListaAnimadores().get(i).getAsignadoAct()){
                                System.out.println(empresa.getListaAnimadores().get(i).getNombre() + " no esta asignado a ninguna actividad");
                            }
                        }
                    }
                    else{
                        System.out.println("no hay animadores registrados.");
                    }

                    System.out.println("");
                    pedirString();
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                    break;
         
            }//SWITCH
       }//WHILE del menu
        System.out.println("EligiÃ³ opciÃ³n 10: Salir del programa");
        System.out.println("");
        System.out.println("Autores: Marco Liguori y Santiago Mc Clew");
    }//clase MAIN    
}//clase Obligatorio
