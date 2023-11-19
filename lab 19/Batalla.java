
import java.util.*;

public class Batalla {
    public static void main ( String [] args){

      
    }
  
     public static void mostrarTablero(Soldado[][] tablero) {
       System.out.println("      1   2   3   4   5   6   7   8   9  10");
       System.out.println("     _______________________________________");
        for (int i = 0; i < 10; i++) {
            if(i<9)
              System.out.print(" " + (i+1)+"  "); 
            else{
            System.out.print(" " + (i+1)+" ");}
            
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] != null) {
                    System.out.print("|" +tablero[i][j].getEjercitoNombre()+tablero[i][j].getNombre().substring(0, 1)+  tablero[i][j].getVidaActual());
                } else {
                    System.out.print("|___");
                }
            }
            System.out.println("|");
        }
    }
     
    public static boolean identificarParejaUnica(int fila, int columna, ArrayList<String> combinacionesUtilizadas) {
        for (String combinacion : combinacionesUtilizadas) {
            if (combinacion.equals(fila + "-" + columna)) {
                return false;
            }
        }

        combinacionesUtilizadas.add(fila + "-" + columna);
        return true;
    }
      
      public static void ubicarEjercitosEnTablero(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2, Soldado[][] tablero) {
        for (Soldado soldado : ejercito1) {
            int fil = soldado.getFila();
            int col = soldado.getColumna();
            tablero[fil - 1][col - 1] = soldado;
        }

        for (Soldado soldado : ejercito2) {
            int fil = soldado.getFila();
            int col = soldado.getColumna();
            tablero[fil - 1][col - 1] = soldado;
        }
    }
      
      
        // para que no hayan 2 en un mismo lugar
    public static void noRepetir(ArrayList<Soldado> ejercito, ArrayList<String> combinacionesUtilizadas) {
        for (int i = 0; i < ejercito.size(); i++) {
            int  fila = ejercito.get(i).getFila();
             int columna =ejercito.get(i).getColumna();

            if (identificarParejaUnica(fila, columna, combinacionesUtilizadas)) {
                
                ejercito.get(i).setFila(fila);
                ejercito.get(i).setColumna(columna);
                    
            }
            else {
               fila = Aleatorio(1, 10);
               columna = Aleatorio(1, 10);
               ejercito.get(i).setFila(fila);
                ejercito.get(i).setColumna(columna);
                i--;
            }
        }
    }
    
    
    public static boolean moverEjercito(Soldado[][] tablero, ArrayList<Soldado> ejercitoTurno, ArrayList<Soldado> ejercitoEspera) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese las coordenadas del soldado para mover (fila, columna) y la dirección (arriba, abajo, izquierda, derecha)");
        int filaActual = scanner.nextInt();
        int columnaActual = scanner.nextInt();
        String direccion = scanner.next();
        boolean estado = false;
        Soldado soldado = buscarSoldado(ejercitoTurno, filaActual, columnaActual);
        while (soldado == null) {
            System.out.println("No se encontró soldado en esa coordenada. Vuelva a ingresar datos:");
            filaActual = scanner.nextInt();
            columnaActual = scanner.nextInt();
            direccion = scanner.next();
            soldado = buscarSoldado(ejercitoTurno, filaActual, columnaActual);
        }
        int filaDestino = soldado.obtenerFilaLlegada(filaActual, direccion);
        int columnaDestino = soldado.obtenerColumnaLlegada(columnaActual, direccion);
        while (!comprobarValidezMovimiento(ejercitoTurno, ejercitoEspera, filaDestino, columnaDestino)) {
            System.out.println("Movimiento inválido. Ingrese nueva dirección:");
            direccion = scanner.next();
            filaDestino = soldado.obtenerFilaLlegada(filaActual, direccion);
            columnaDestino = soldado.obtenerColumnaLlegada(columnaActual, direccion);
        }
        Soldado soldadoRivalTurno = buscarSoldado(ejercitoEspera, filaDestino, columnaDestino);
        if (soldadoRivalTurno != null) {
            System.out.println("\nSOLDADOS RIVALES COINCIDEN ======> HAY BATALLA\n");
            ejercitoGanador(soldado, soldadoRivalTurno);
            ejercitoEspera.remove(soldadoRivalTurno);
            estado = true;
        } else {
            cambiarPosicionSoldado(tablero, soldado, filaDestino, columnaDestino);
        }
        return estado;
    }

    public static void cambiarPosicionSoldado(Soldado[][] tablero, Soldado soldado, int nuevaFila, int nuevaColumna) {
        int filaActual = soldado.getFila();
        int columnaActual = soldado.getColumna();
        tablero[filaActual - 1][columnaActual - 1] = null;
        soldado.setFila(nuevaFila);
        soldado.setColumna(nuevaColumna);
        tablero[nuevaFila - 1][nuevaColumna - 1] = soldado;
    }

    public static Soldado buscarSoldado(ArrayList<Soldado> soldados, int fila, int columna) {
        for (Soldado soldadoActual : soldados) {
            if (soldadoActual.getFila() == fila && soldadoActual.getColumna() == columna) {
                return soldadoActual;
            }
        }
        return null;
    }

    public static boolean comprobarValidezMovimiento(ArrayList<Soldado> ejercitoTurno, ArrayList<Soldado> ejercitoEspera, int fila, int columna) {
        if (fila < 1 || fila > 10 || columna < 1 || columna > 10) {
            return false;
        }
        for (Soldado soldadoActual : ejercitoTurno) {
            if (soldadoActual.getFila() == fila && soldadoActual.getColumna() == columna) {
                return false;
            }
            return true;
        }
        for (Soldado soldadoActual : ejercitoEspera) {
            if (soldadoActual.getFila() == fila && soldadoActual.getColumna() == columna) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static void ejercitoGanador(Soldado soldado1, Soldado soldado2) {
        double probabilidadSoldado1 = soldado1.getNivelVida() / (double) (soldado1.getNivelVida() + soldado2.getNivelVida());
        double probabilidadSoldado2 = soldado2.getNivelVida() / (double) (soldado1.getNivelVida() + soldado2.getNivelVida());
        double random = Math.random();
        if (random < probabilidadSoldado1) {
            System.out.println("¡El " + soldado1.getNombre() + " del ejercito " + soldado1.getEjercitoNombre() + " ganó por una probabilidad del " + probabilidadSoldado1 * 100 + "%!\n");
            soldado1.aumentarNivelVidaActual();
        } else {
            System.out.println("¡El " + soldado2.getNombre() + " del ejercito " + soldado2.getEjercitoNombre() + " ganó por una probabilidad del " + probabilidadSoldado2 * 100 + "%!\n");
            soldado2.aumentarNivelVidaActual();
        }
    }


     public static int Aleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
     
     public static void mostrarejercito(ArrayList<Soldado> soldados) {
        
        for (Soldado soldado : soldados) {
            System.out.println(soldado.toString());
        }
    }
}
