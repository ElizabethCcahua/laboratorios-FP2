import java.util.*;

public class Lab16 {
    public static void main(String[] args) {
            
            Scanner scanner = new Scanner(System.in);
                 
            Mapa mapa = new Mapa();
           
           ArrayList<Ejercito>[] reinos=  mapa.tableroBatalla();
           ArrayList<Ejercito> reino1 =reinos[0];
            ArrayList<Ejercito> reino2 =reinos[1];
        }
    
         // Reino turno: esta moviendo , Reino espera: solo observa
        public static boolean moverEjercito(Ejercito[][] tablero, ArrayList<Ejercito> reinoTurno, ArrayList<Ejercito> reinoEspera) {
                    // estado es para ver si hay batalla (true)
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Ingrese las coordenadas del ejercito para mover (fila, columna) y la dirección (arriba, abajo, izquierda, derecha)");
                    int filaActual = scanner.nextInt();
                    int columnaActual = scanner.nextInt();
                    String direccion = scanner.next();
                    boolean estado = false;
                    Ejercito ejercito = buscarEjercito(reinoTurno, filaActual, columnaActual);
                    while (ejercito == null) {
                        System.out.println("No se encontró ejercito en esa coordenada. Vuelva a ingresar datos:");
                        filaActual = scanner.nextInt();
                        columnaActual = scanner.nextInt();
                        direccion = scanner.next();
                        ejercito = buscarEjercito(reinoTurno, filaActual, columnaActual);
                    }
                    int filaDestino = ejercito.obtenerFilaLlegada(filaActual, direccion);
                    int columnaDestino = ejercito.obtenerColumnaLlegada(columnaActual, direccion);
                    
                    while (!comprobarValidezMovimiento(reinoTurno, reinoEspera, filaDestino, columnaDestino)) {
                        System.out.println("Movimiento inválido. Ingrese nueva dirección:");
                        direccion = scanner.next();
                        filaDestino = ejercito.obtenerFilaLlegada(filaActual, direccion);
                        columnaDestino = ejercito.obtenerColumnaLlegada(columnaActual, direccion);
                    }
                    
                    Ejercito ejercitoRivalTurno = buscarEjercito(reinoEspera, filaDestino, columnaDestino);
                    if (ejercitoRivalTurno != null) {
                        System.out.println("HAY BATALLAA");
                        ejercitoGanador(ejercito, ejercitoRivalTurno);
                            reinoEspera.remove(ejercitoRivalTurno);
                        estado = true;
                    } else {
                        // realiza movimiento
                        cambiarPosicionEjercito(tablero, ejercito, filaDestino, columnaDestino);
                    }
                    return estado;
    }
    
    // Cambia y actualiza las coordenadas del Ejercito
    public static void cambiarPosicionEjercito(Ejercito[][] tablero, Ejercito ejercito, int nuevaFila, int nuevaColumna) {
            int filaActual = ejercito.getFila();
            int columnaActual = ejercito.getColumna();
            // Vaciar la posición actual del Ejercito
            tablero[filaActual - 1][columnaActual - 1] = null;
            // Actualizar las nuevas coordenadas del Ejercito
            ejercito.setFila(nuevaFila);
            ejercito.setColumna(nuevaColumna);
            // Colocar al Ejercito en su nueva posición en el tablero
            tablero[nuevaFila - 1][nuevaColumna - 1] = ejercito;
    }
    
    // Busca si la posición del Ejercito ya está ocupada
    public static Ejercito buscarEjercito(ArrayList<Ejercito> ejercito, int fila, int columna) {
                for (Ejercito ejercitoActual : ejercito) {
                    if (ejercitoActual.getFila() == fila && ejercitoActual.getColumna() == columna) {
                        return ejercitoActual;
                    }
                }
                return null;
    }
    
    public static boolean comprobarValidezMovimiento(ArrayList<Ejercito> reinoTurno, ArrayList<Ejercito> reinoEspera, int fila, int columna) {
                // Para que no se salga del tablero
                if (fila < 1 || fila > 10 || columna < 1 || columna > 10) {
                    return false;
                }
                // Para que no se repita
                for (Ejercito ejercitoActual : reinoTurno) {
                    if (ejercitoActual.getFila() == fila && ejercitoActual.getColumna() == columna) {
                        return false;
                    }
                     return true;
                }
                for (Ejercito ejercitoActual : reinoEspera) {
                    if (ejercitoActual.getFila() == fila && ejercitoActual.getColumna() == columna) {
                        return false;
                    }
                     return true;
                }
                return true;
    }
    
    public static void ejercitoGanador(Ejercito ejercito1, Ejercito ejercito2) {
            double probabilidadSoldado1 = ejercito1.getSumatoriaNivelVidaSoldados() / (double) (ejercito1.getSumatoriaNivelVidaSoldados() + ejercito2.getSumatoriaNivelVidaSoldados());
            double probabilidadSoldado2 = ejercito2.getSumatoriaNivelVidaSoldados()/ (double) (ejercito1.getSumatoriaNivelVidaSoldados() + ejercito2.getSumatoriaNivelVidaSoldados());
            
            double random = Math.random();
            
            if (random < probabilidadSoldado1) {
                System.out.println("¡El ejercito " + ejercito1.getNombre()+ "perteneciente al reino "+ejercito1.getReino()+"CON"+ejercito1.getSumatoriaNivelVidaSoldados()+"DE SUMATORIA DE VIDA gano por la posibilidad del "+ probabilidadSoldado1+"%");
                ejercito1.aumentarVidaActualSoldados() ;
            } else {
                System.out.println("¡El ejercito " + ejercito2.getNombre() + "perteneciente al reino  " +ejercito2.getReino()+" CON "+ejercito2.getSumatoriaNivelVidaSoldados()+" DE SUMATOR5IA DE VIDA gano por la posibilidad del "+ probabilidadSoldado2+"%");
                ejercito2.aumentarVidaActualSoldados();
            }
        }
}
