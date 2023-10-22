import java.util.*;
public class VideoJuego {
    public static void main ( String [] args){
       ArrayList <Soldado> ejercito1 = new ArrayList<Soldado>();
       ArrayList<Soldado> ejercito2 = new ArrayList<Soldado>(); 
        //creamos un arraylist para almacenar las combinaciones utilizadas con el fin de que no caigan dos soldados en la misma posicion
       ArrayList<String> combinacionesUtilizadas = new ArrayList<>();
        inicializarEjercito(ejercito1,combinacionesUtilizadas);
        inicializarEjercito(ejercito2,combinacionesUtilizadas);
       
        
        for (int i = 0; i < ejercito1.size(); i++) {
    ejercito1.get(i).setNombre("Soldado" + i + "X1");
    ejercito1.get(i).setCaracteristica("A");// la caracteristica para identificar al ejercito 1 sera "A"
        }
        
        for (int i = 0; i < ejercito2.size(); i++) {
    ejercito2.get(i).setNombre("Soldado" + i + "X2");
    ejercito2.get(i).setCaracteristica("B");// la caracteristica para identificar al ejercito 2 sera "B"
        }

        //CREAMOS UN ARREGLO BIDIMENSIONAL PARA EL TABLERO
       Soldado[][] tablero = new Soldado[10][10];
        ubicarSoldadosEnTablero(ejercito1, ejercito2, tablero);
        mostrarTablero(ejercito1,ejercito2);
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

            Soldado soldado1 = new Soldado( nivelAtaque, nivelDefensa, vida, vida, 0, "defensiva", true);
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
}
