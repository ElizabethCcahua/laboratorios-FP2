import java.util.*;
public class VideoJuego {
    public static void main(String[] args) {
        menuPrincipal();
    }
    
     public static void menuPrincipal() {
     Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("----- MENÚ PRINCIPAL -----");
            System.out.println("1. Juego rápido");
            System.out.println("2. Juego personalizado");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    
                    break;
                case 2:   
                    
                    break;
                case 3:
                    System.out.println("FIN");
                    break;
                default:
                    System.out.println("opción inválida.seleccione una opción válida.");
                    break;
            }
            
        } while (opcion != 3);
    }

public static void jugarJuegoRapido() {
        
         Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println(" recuerde que para salir en cualquier momento solo escriba la palabra salir ");
           
            juegoRapido();
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    juegoRapido();
                    pregunta();
                    
                    break;
                case 2:
                    salir = true;
                     menuPrincipal();
                    break;
                default:
                   System.out.println("no es una opcion valida");
                    break;
            }
        }    
    }
    
 public static void pregunta() {
         Scanner scanner = new Scanner(System.in);
         
         int opcion = scanner.nextInt();
            
         System.out.println("1. volver a jugar");
         System.out.println("2. volver al menu principal");
                    
                    switch (opcion) {
                        case 1:
                            jugarJuegoRapido() ;
                        case 2:   
                            menuPrincipal();
                        }
     }

    public static void juegoRapido() {
        // CODIGO LAB 11
        System.out.println("juego rápido");
         ArrayList<Soldado>[] ejercitosGenerados=generarEjercitos();
         
         ArrayList<Soldado> ejercito1 = ejercitosGenerados[0];
           ArrayList<Soldado> ejercito2 =  ejercitosGenerados[1];
              codigoJuegoRapido(ejercito1,ejercito2);
       pregunta();
    }

public static ArrayList<Soldado>[] generarEjercitos() {
    ArrayList<Soldado> ejercito1 = new ArrayList<>();
    ArrayList<Soldado> ejercito2 = new ArrayList<>(); 
    // Creamos un ArrayList para almacenar las combinaciones utilizadas con el fin de que no caigan dos soldados en la misma posición
    ArrayList<String> combinacionesUtilizadas = new ArrayList<>();
    inicializarEjercito(ejercito1, combinacionesUtilizadas);
    inicializarEjercito(ejercito2, combinacionesUtilizadas);
    
    for (int i = 0; i < ejercito1.size(); i++) {
        ejercito1.get(i).setNombre("Soldado" + i + "XA");
        ejercito1.get(i).setCaracteristica("A"); // La característica para identificar al ejército 1 será "A"
    }
    
    for (int i = 0; i < ejercito2.size(); i++) {
        ejercito2.get(i).setNombre("Soldado" + i + "XB");
        ejercito2.get(i).setCaracteristica("B"); // La característica para identificar al ejército 2 será "B"
    }
    
    ArrayList<Soldado>[] arregloEjercitos = new ArrayList[2];
    arregloEjercitos[0] = ejercito1;
    arregloEjercitos[1] = ejercito2;
    
    return arregloEjercitos;
}

public static void codigoJuegoRapido(ArrayList<Soldado>  ejercito1,ArrayList<Soldado>  ejercito2) {
   
        //CREAMOS UN ARREGLO BIDIMENSIONAL PARA EL TABLERO
       Soldado[][] tablero = new Soldado[10][10];
        ubicarSoldadosEnTablero(ejercito1, ejercito2, tablero);
        mostrarTablero(tablero);

        while (!ejercito1.isEmpty() && !ejercito2.isEmpty()) {
            // Turno de ejercito 1
            System.out.println("Turno del ejercito 1");
            moverSoldado(tablero,ejercito1, ejercito2);
           
            mostrarTablero(tablero);
            
            // si queda vacio el ejercito 2 gana el 1
            if (ejercito2.isEmpty()) {
                System.out.println("EL GANADOR ES EL EJERCITO 1");
                break;
            }
            
            // Turno del ejercito 2
            System.out.println("Turno del ejercito 2");
            moverSoldado(tablero,ejercito2, ejercito1);
       
            mostrarTablero(tablero);
            
           // si queda vacio el ejercito 1 gana el 2
            if (ejercito1.isEmpty()) {
                System.out.println("EL GANADOR ES EL EJERCITO 2");
                break;
            }
        }
    } 
    
    public static void mostrarDatosEjercitos(ArrayList<Soldado>[] arregloEjercitos) {
    ArrayList<Soldado> ejercito1 = arregloEjercitos[0];
    ArrayList<Soldado> ejercito2 = arregloEjercitos[1];
    
    System.out.println("Soldados del Ejército 1:");
    for (Soldado soldado : ejercito1) {
        System.out.println(soldado.getNombre());
    }
    
    System.out.println("Soldados del Ejército 2:");
    for (Soldado soldado : ejercito2) {
        System.out.println( soldado.getNombre());
    }
}
        
     // Usamos metodo identificarParejaUnica para poder inicializar los ejercitos sin problemas en las posiciones 
     public static void inicializarEjercito(ArrayList<Soldado> ejercito,ArrayList<String> combinacionesUtilizadas) {
        for (int i = 0; i < Aleatorio(1,10); i++) {
            int fila =Aleatorio(1,10);
            int columna =Aleatorio(1,10);

            if (identificarParejaUnica(fila, columna,  combinacionesUtilizadas)){
                
            int vida = Aleatorio(1, 5);
            int nivelAtaque =Aleatorio(1, 5);
            int nivelDefensa = Aleatorio(1, 5);

            Soldado soldado1 = new Soldado( nivelAtaque, nivelDefensa, vida, 0, "defensiva", true);
            soldado1.setFila(fila);
            soldado1.setColumna(columna);
            ejercito.add(soldado1);       
        }
            else
                i--;
        }    
    }

//metodo que permitira identificar un par de fila y columna que no sea repetido anterior mente por otro soldado
    public static boolean identificarParejaUnica(int fila, int columna, ArrayList<String> combinacionesUtilizadas) {
    // Si la pareja existe retorna falso, para que se busque otra pareja, de lo contrario lo añade al ArrayList
    for (String combinacion : combinacionesUtilizadas) {
        if (combinacion.equals(fila + "-" + columna)) {
            return false;
        }
    }
        combinacionesUtilizadas.add(fila + "-" + columna);
            return true;
    }

   public static void ubicarSoldadosEnTablero(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2, Soldado[][] tablero) {
    for (Soldado soldado : ejercito1) {
        int fila = soldado.getFila();
        int columna = soldado.getColumna();
        tablero[fila - 1][columna - 1] = soldado;
    }
    for (Soldado soldado : ejercito2) {
        int fila = soldado.getFila();
        int columna = soldado.getColumna();
        tablero[fila - 1][columna - 1] = soldado;
    }
}

public static void mostrarTablero(Soldado[][] tablero) {
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (tablero[i][j] != null) {
                System.out.print("|" + tablero[i][j].getCaracteristica() + "-" + tablero[i][j].getVidaActual());
            } else {
                System.out.print("|___");
            }
        }
        System.out.println();
    }
}
      //ejercito turno: esta moviendo , ejercito espera: solo observa
    public static void moverSoldado(Soldado[][] tablero,ArrayList<Soldado> ejercitoTurno, ArrayList<Soldado> ejercitoEspera) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese las coordenadas del soldado para mover (fila, columna) y la dirección (arriba, abajo, izquierda, derecha)");
        int filaActual = scanner.nextInt();
        int columnaActual = scanner.nextInt();
        String direccion = scanner.next();
        
        // Verificar si hay un soldado en las coordenadas ingresadas
        Soldado soldado = buscarSoldado(ejercitoTurno, filaActual, columnaActual);
        while (soldado == null) {
            System.out.println("No se encontro soldado en esa coordenada vuelva a ingresar datos: ");
            filaActual = scanner.nextInt();
            columnaActual = scanner.nextInt();
            direccion = scanner.next();
            soldado = buscarSoldado(ejercitoTurno, filaActual, columnaActual);
        }
        
        System.out.println("Ingrese la dirección de movimiento (arriba, abajo, izquierda, derecha):");
       
        
        // Verificar si el movimiento es válido
        int filaDestino = obtenerFilaLlegada(filaActual, direccion);
        int columnaDestino = obtenerColumnaLlegada(columnaActual, direccion);
        
          
        while (!ComprobarValidezMovimiento(ejercitoTurno, ejercitoEspera, filaDestino, columnaDestino)) {
            System.out.println("Movimiento inválido. Ingrese nueva dirección:");
            direccion = scanner.next();
            filaDestino = obtenerFilaLlegada(filaActual, direccion);
            columnaDestino = obtenerColumnaLlegada(columnaActual, direccion);
        }
        
        // Realizar el movimiento
        cambiarPosicionSoldado(tablero,soldado, filaDestino, columnaDestino);
        
        // Verificar si hay un soldado rival en la posición destino para realizar la batalla
        Soldado soldadoRivalTurno = buscarSoldado(ejercitoEspera, filaDestino, columnaDestino);
        if (soldadoRivalTurno != null) {
            soldadoGanador(soldado, soldadoRivalTurno);
            ejercitoEspera.remove(soldadoRivalTurno);
        }
    }

//  cambia y actualiza las coordenadas del soldado
    public static void cambiarPosicionSoldado(Soldado[][] tablero,Soldado soldado, int nuevaFila, int nuevaColumna) {
    int filaActual = soldado.getFila();
    int columnaActual = soldado.getColumna();
    
    // Vaciar la posición actual del soldado
    tablero[filaActual - 1][columnaActual - 1] = null;
    
    // Actualizar las nuevas coordenadas del soldado
    soldado.setFila(nuevaFila);
    soldado.setColumna(nuevaColumna);
    // Colocar al soldado en su nueva posición en el tablero
    tablero[nuevaFila - 1][nuevaColumna - 1] = soldado;
    }
// busca si la posicion del soldado ya esta en 
    public static Soldado buscarSoldado(ArrayList<Soldado> ejercito, int fila, int columna) {
        for (Soldado soldado : ejercito) {
            if (soldado.getFila() == fila && soldado.getColumna() == columna) {
                return soldado;
            }
        }
        return null;
    }

public static boolean ComprobarValidezMovimiento(ArrayList<Soldado> ejercitoTurno, ArrayList<Soldado> ejercitoEspera, int fila, int columna) {
        //para q no se salga del tablero
        if (fila < 1 || fila > 10 || columna < 1 || columna > 10) {
            return false;
        }
        //para que no repita
        for (Soldado soldado : ejercitoTurno) {
            if (soldado.getFila() == fila && soldado.getColumna() == columna ) {
                return false;
            }
            return true;
        }
        
        for (Soldado soldado : ejercitoEspera) {
            if (soldado.getFila() == fila && soldado.getColumna() == columna) {
                return false;
            }
            return true;
        }
        return true;
        
    }

 public static void soldadoGanador(Soldado soldado1, Soldado soldado2) {
        double probabilidadSoldado1 = soldado1.getVidaActual() / (double) (soldado1.getVidaActual() + soldado2.getVidaActual());
        double probabilidadSoldado2 = soldado2.getVidaActual() / (double) (soldado1.getVidaActual() + soldado2.getVidaActual());
        
        double random = Math.random();
        
        if (random < probabilidadSoldado1) {
            System.out.println("¡El soldado " + soldado1.getNombre() + "perteneciente al ejercito 1"+" gano por la posibilidad del "+ probabilidadSoldado1+"%");
            soldado1.setVidaActual(soldado1.getVidaActual() + 1);
        } else {
            System.out.println("¡El soldado " + soldado2.getNombre() + "perteneciente al ejercito 2"+" gano por la posibilidad del "+ probabilidadSoldado2+"%");
            soldado2.setVidaActual(soldado2.getVidaActual() + 1);
        }
    }
    
     public static int obtenerFilaLlegada(int filaActual, String direccion) {
        switch (direccion) {
            case "arriba":
                return filaActual - 1;
            case "abajo":
                return filaActual + 1;
            default:
                return filaActual;
        }
    }

public static int obtenerColumnaLlegada(int columnaActual, String direccion) {
        switch (direccion) {
            case "izquierda":
                return columnaActual - 1;
            case "derecha":
                return columnaActual + 1;
            default:
                return columnaActual;
        }
    }
    
    //metodo para poder obtener numeros aleatorios
    public static int Aleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
