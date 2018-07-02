package obligatorio;
import java.util.*;
//Marco Liguori y Santiago Mc Clew

public class Prueba extends Sistema  {	
    

    public static Socio crearSocio(){ //crea un nuevo socio y pide los datos de cada socio cada vez que se invoca
        Socio nuevoSocio = new Socio(); //crea un nuevo objeto Socio
        
        System.out.print("Ingresar nombre del socio: ");
        nuevoSocio.setNombre(pedirString());
        
        System.out.print("Ingresar documento: ");
        nuevoSocio.setDocumento(pedirString());

        System.out.print("Ingresar edad: ");
        nuevoSocio.setEdad(DatoValido(50,130));

        System.out.print("Ingresar dirección: ");
        nuevoSocio.setDireccion(pedirString());

        System.out.println("");
        return (nuevoSocio); //devuelve un nuevo socio con sus datos correspondientes ya ingresados.
    }  // fin metodo crear socio
    
    
    public static Animador crearAnimador(){ //crea un nuevo socio y pide los datos de cada socio cada vez que se invoca
        Animador nuevoAnimador = new Animador(); //crea un nuevo objeto animador
        
        System.out.print("Ingresar nombre del animador: ");
        nuevoAnimador.setNombre(pedirString());
        
        System.out.print("Ingresar documento: ");
        nuevoAnimador.setDocumento(pedirString());
        
        System.out.println("Ingrese los anos de experiencia del animador");
        nuevoAnimador.setAniosXP(DatoValido(1,65));
        
        System.out.println("");
        return (nuevoAnimador); //devuelve un nuevo socio con sus datos correspondientes ya ingresados.
    }  // fin metodo crear socio
    
    
    public static Inscripcion crearInscripcion(Socio datosSocio, Actividad datosActividad){  
        datosActividad.setHayInscriptos(true);
        
        System.out.print("Ingresar teléfono: ");
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
                System.out.println("Eligió teatro como tipo de actividad.");
                break;
            case 2:
                nuevaActividad.setTipo("2 Cine");
                System.out.println("Eligió cine como tipo de actividad.");
                break;
            case 3:
                nuevaActividad.setTipo("3 Viaje");
                System.out.println("Eligió viaje como tipo de actividad.");
                break;
            case 4:
                nuevaActividad.setTipo("4 Paseo local");
                System.out.println("Eligió paseo local como tipo de actividad.");
                break;
            case 5:
                nuevaActividad.setTipo("5 Paseo interdepartamental");
                System.out.println("Eligió paseo interdepartamental como tipo de actividad.");
                break;
            case 6:
                nuevaActividad.setTipo("6 Caminata");
                System.out.println("Eligió caminata como tipo de actividad.");
                break;
            case 7:
                nuevaActividad.setTipo("7 Otro");
                System.out.println("Eligió otro tipo de actividad.");
                break;
        }//fin switch elegir tipo de actividad
  
        
        System.out.print("Ingresar hora de comienzo de la actividad entre las 7 y las 21: ");   //pide hora de comienzo de actividad y verifico que sea correcta
        nuevaActividad.setHoraComienzo(DatoValido(7,21));        
        
        
        System.out.print("Ingresar capacidad máxima: ");  // pido ingresar capacidad de la actividad
        nuevaActividad.setCapmax(DatoValido(1,Integer.MAX_VALUE));
        
        System.out.print("Ingresar costo de la actividad: $"); //pido ingresar costo
        nuevaActividad.setCosto(DatoValido(0,Integer.MAX_VALUE));
        
        nuevaActividad.setAnimador((Animador) seleccionarDeLista(empresa.getListaAnimadores(), "elija un animador:"));
        nuevaActividad.getAnimador().setAsignadoAct(true);
        
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

    //metodo para seleccionar un objeto de una lista cualquiera:
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
                         + "\n            MENÚ PRINCIPAL            "
                         + ""
                         + "\nSeleccione una tarea a realizar:   "
                         + "\n "
                         + "\n  1- Ingresar socio  "
                         + "\n  2- Ingresar animador  "
                         + "\n  3- Ingresar actividad "
                         + "\n  4- Nueva inscripcion.  "
                         + "\n  5- Gráfica de actividades por dia.  "
                       + "\n  6- Lista ordenada por fecha/tipo de actividades. "
                         + "\n  7- Eliminar una actividad"
                         + "\n  8- Actividades favoritas"
                         + "\n  9- Animadores sin actividad"
                         + "\n  10- Salir"
                         + "");
        System.out.print("Ingresar opcion: ");
    }
    
    /*-----------------------------------------------------------------------*/
    /*--------------------------------------MAIN-----------------------------*/
    /*-----------------------------------------------------------------------*/
    
    public static void main(String[] args) {
        Sistema empresa = new Sistema();
        
        mostrarOpciones();
        
        int opcion = DatoValido(1,10);
        
        while (opcion != 10){ //pedir que se ingrese opcion del menu hasta que sea = a 6 y termine el programa
            switch (opcion){
                case 1: 
                    System.out.println("Eligio opcion 1: Agregar un socio");
                    empresa.agregarSocio(crearSocio());
                    
                    System.out.println("Enter para continuar");
                    pedirString();
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                    break;
            
     
                case 2:
                    System.out.println("Eligio opcion 2: Agregar nuevo animador");
                    empresa.agregarAnimador(crearAnimador());
                    
                    System.out.println("Enter para continuar");
                    pedirString();
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                    break; 
                    
                    
                case 3:
                    System.out.println("Eligio opcion 3: Crear una actividad");
                    if(! empresa.getListaAnimadores().isEmpty()){  //si la lista de animadores no es vacia crea una actividad
                        empresa.agregarActividad(crearActividad(empresa));
                      
                    }
                    else{
                        System.out.println("No se puede crear una actividad sin animadores");
                    }
                    
                    System.out.println("Enter para continuar");
                    pedirString();
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                    break;
                   
                case 4:
                    System.out.println("Eligio opcion 4: Crear una inscripcion");
                    if(! empresa.getListaActividades().isEmpty() && ! empresa.getListaSocios().isEmpty()){  //si la lista de actividades y socios no es vacia
                        Actividad activ = (Actividad) seleccionarDeLista(empresa.getListaActividades(), "Actividades disponibles: ");
                        Socio socio = (Socio) seleccionarDeLista(empresa.getListaSocios(), "Socios disponibles: ");
                        
                        if (activ.getCapmax() != 0){ //si hay cupos crea la inscripcion
                            empresa.agregarInscripcion(crearInscripcion(socio, activ));
                            activ.setCapmax(activ.getCapmax()-1); //un cupo menos para esa actividad.
                        }
                        else{
                            System.out.println("no hay mas cupos para esa actividad.");                           
                        }                        
                    }
                    else{
                        System.out.println("No se puede crear una inscripcion sin socios y actividades");
                    }
                    
                    System.out.println("Enter para continuar");
                    pedirString();
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                    break;
            
                case 5:
                    System.out.println("Eligio opcion 5: Mostrar Grafica");
                    if(! empresa.getListaActividades().isEmpty()){  //si la lista de actividades no es vacia, pido un dia y muestro activiades
                        System.out.print("Ingrese un dia: ");
                        int diaP = DatoValido(1,31);
                        boolean hayActividades = false;
                        int [] tipos = new int [7];
                        
                        for (int i = 0; i < empresa.getListaActividades().size(); i++) {
                            if(empresa.getListaActividades().get(i).getDia() == diaP){
                                tipos[empresa.getListaActividades().get(i).getTipoEntero()]++;
                                hayActividades = true;
                            }
                        }
                        
                        
                        if(hayActividades){ //si ese dia hay actividades muestro la grafica
                            for (int i = 1; i < tipos.length; i++) {
                                if(tipos[i]>0){
                                    System.out.print("  " + i +" - ");
                                    for (int j = 1; j <= tipos[i] ; j++) {
                                        System.out.print("*");

                                    }
                                    System.out.println("");
                                }
                            }
                        }
                        else{
                            System.out.println("no hay actividades ese dia.");
                        }
                        
                        
                    }//del if
                    else{
                        System.out.println("no hay actividades registradas");
                    }
                    
                    System.out.println("Enter para continuar");
                    pedirString(); 
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                   
                    break;
                    
                case 6:
                    System.out.println("Listado de actividades por fecha/tipo");
                                                          
                    if (! empresa.getListaActividades().isEmpty()){//si la lista no es vacia
                        empresa.ordenar();//la ordena
                        empresa.mostrarLista(empresa.getListaActividades());//la imprime
                    }
                    else{
                        System.out.println("no hay actividades registradas");
                    }
                    
                    System.out.println("Enter para continuar");
                    pedirString();
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                    break;
                    
                case 7:
                    System.out.println("Eligio opcion 7: Dar de baja una actividad"); 
                    
                    if (! empresa.getListaActividades().isEmpty()){
                        Actividad aBorrar = (Actividad) seleccionarDeLista(empresa.getListaActividades(), "Elija actividad a borrar");//muestra la lista y se elije una actividad a borrar
                        empresa.borrarInscripciones(aBorrar); //borra inscripciones y muestra telefonos
                        aBorrar.getAnimador().setAsignadoAct(false);// ese animador queda sin actividad asignada

                        empresa.getListaActividades().remove(aBorrar); //borra la actividad
                        
                        System.out.println("");
                        System.out.println("se borro la actividad elegida y se desplegaron los telefonos de inscriptos");
                    }
                    else{ 
                        System.out.println("no hay actividades registradas.");
                    }
                    
                    System.out.println("Enter para continuar");
                    pedirString();
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                    break;
                    
                case 8:
                    System.out.println("opcion 8, actividades preferidas");
                    if (! empresa.getListaActividades().isEmpty()){
                        int actPreferidas [] = new int [7];  //creo array de 8 espacios, el espacio 0 no se usa
                        
                        for (int i = 0; i < empresa.getListaInscripciones().size(); i++) {
                            actPreferidas[empresa.getListaInscripciones().get(i).getActividad().getTipoEntero()]++; //lleno el array con cantidad de actividaes
                                                                                                                    //de cada tipo
                        }

                        int max = actPreferidas[1]; //defino el maximo como el primer valor para luego comparar.

                        for (int i = 2; i < actPreferidas.length; i++) {  //busco el max en el array
                            if(max < actPreferidas[i]){
                                max = actPreferidas[i];
                            }
                        }
                        
                        System.out.println("");
                        
                        if (max != 0){
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
                            System.out.println("no hay inscripciones registradas.");
                        }
                    }
                    else{
                        System.out.println("no hay actividades registradas");
                    }
    
                    System.out.println("Enter para continuar");
                    pedirString();
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                    break;
                    
                case 9:
                    System.out.println("Eligió opción 9: animadores sin actividad");
                    boolean todosOcupados = false;
                    if (! empresa.getListaAnimadores().isEmpty()){  //si la lista de animadores no es vacia...
                        for (int i = 0; i < empresa.getListaAnimadores().size(); i++) {
                            if (! empresa.getListaAnimadores().get(i).getAsignadoAct()){//si no esta asigando a ninguna actividad lo muestra
                                System.out.println(empresa.getListaAnimadores().get(i).getNombre() + " no esta asignado a ninguna actividad");
                                todosOcupados = true;
                            }
                        }
                        if (! todosOcupados){
                            System.out.println("todos los animadores estan asignados a alguna actividad");
                        }
                    }
                                       
                    else{
                        System.out.println("no hay animadores registrados.");
                    }

                    System.out.println("Enter para continuar");
                    pedirString();
                    mostrarOpciones();
                    opcion = DatoValido(1,10);
                    break;
         
            }//SWITCH
       }//WHILE del menu
        System.out.println("Eligió opción 10: Salir del programa");
        System.out.println("");
        System.out.println("Autores: Marco Liguori y Santiago Mc Clew");
    }//clase MAIN    
}//clase Obligatorio
