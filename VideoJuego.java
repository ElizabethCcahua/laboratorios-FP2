import java.util.*;
public class BatallaDemo {
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

    //metodo para ubicar ambos ejercitos (arraylist)y mostrarlos en el tablero (arreglo bidimensional)
public static void mostrarTablero(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2) {
    Soldado[][] tablero = new Soldado[10][10];

    // Ubica soldados del ejercito1 en el tablero
    for (Soldado soldado : ejercito1) {
        int fila = soldado.getFila();
        int columna = soldado.getColumna();
        System.out.println(fila+"-"+columna);
        tablero[fila-1][columna-1] = soldado;
    }

    // Ubica soldados del ejercito2 en el tablero
    for (Soldado soldado : ejercito2) {
        int fila = soldado.getFila();
        int columna = soldado.getColumna();
        System.out.println(fila+"v"+columna);
        tablero[fila-1][columna-1] = soldado;
    }

    // muestra el tablero
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (tablero[i][j] != null) {
                System.out.print("|" + tablero[i][j].getCaracteristica() +"-"+tablero[i][j].getVidaActual());
            } else {
                System.out.print("|___");
            }
        }
        System.out.println();
    }
}
    
    //metodo para poder obtener numeros aleatorios
    public static int Aleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
