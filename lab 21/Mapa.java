import java.util.ArrayList; 

 
 class Mapa  {
    private final String territorio;
    public Soldado[][] tablero;
    
    public Mapa() {
        String[] territorios = {"bosque", "campo abierto", "montaña", "desierto", "playa"};
        this.territorio = territorios[(int)(Math.random() * territorios.length)];
    }

   public Ejercito[] tableroBatalla() {
    Ejercito ejercitoPrincipal1 = new Ejercito();
    Ejercito ejercitoPrincipal2 = new Ejercito();
    ArrayList<String> combinacionesUtilizadas = new ArrayList<>();
    ArrayList<Soldado> reino1 = ejercitoPrincipal1.generarEjercitoSoldadosAleatorio();

    //para cambiar el  nombre en cada objeto ejercito sea el 1 o 2 u otros nombres
    for (Soldado soldado : reino1) {
        String nombreActual = soldado.getNombre();
        String nuevoNombre = nombreActual + "X1";
        soldado.setNombre(nuevoNombre);
        
        soldado.setEjercitoNombre("1");
    }
    noRepetir(reino1, combinacionesUtilizadas);
    
    ArrayList<Soldado> reino2 = ejercitoPrincipal2.generarEjercitoSoldadosAleatorio();
    
     for (Soldado soldado : reino2) {
        String nombreActual = soldado.getNombre();
        String nuevoNombre = nombreActual + "X2";
        soldado.setNombre(nuevoNombre);
        
         soldado.setEjercitoNombre("2");
    }
    noRepetir(reino2, combinacionesUtilizadas);

    //por si en la generacion se repite el mismo nombre de reinoo
    while(ejercitoPrincipal1.getReino().equals(ejercitoPrincipal2.getReino())){
    reino2= ejercitoPrincipal2.generarEjercitoSoldadosAleatorio();
     
    }
    
    BonusTerritorio(reino1);
    BonusTerritorio(reino2);
    
    tablero = new Soldado[10][10];
    ubicarEjercitosEnTablero(reino1, reino2, tablero);
    mostrarTablero(tablero);


    // Devolvemos un arreglo de tamaño 2 con los reinos reino1 y reino2
    Ejercito[] ejercitos = new Ejercito[2];
    ejercitos[0] = ejercitoPrincipal1;
    ejercitos[1] = ejercitoPrincipal2;
    return ejercitos;
}

  // para que no hayan 2 en un mismo lugar
    public void noRepetir(ArrayList<Soldado> reino, ArrayList<String> combinacionesUtilizadas) {
        for (int i = 0; i < reino.size(); i++) {
            int  fila = reino.get(i).getFila();
             int columna =reino.get(i).getColumna();

            if (identificarParejaUnica(fila, columna, combinacionesUtilizadas)) {
                
                reino.get(i).setFila(fila);
                reino.get(i).setColumna(columna);
                    
            }
            else {
               fila = Aleatorio(1, 10);
               columna = Aleatorio(1, 10);
               reino.get(i).setFila(fila);
                reino.get(i).setColumna(columna);
                i--;
            }
        }
    }
 
    private boolean identificarParejaUnica(int fila, int columna, ArrayList<String> combinacionesUtilizadas) {
        for (String combinacion : combinacionesUtilizadas) {
            if (combinacion.equals(fila + "-" + columna)) {
                return false;
            }
        }

        combinacionesUtilizadas.add(fila + "-" + columna);
        return true;
    }

    private void ubicarEjercitosEnTablero(ArrayList<Soldado> reino1, ArrayList<Soldado> reino2, Soldado[][] tablero) {
        for (Soldado soldado : reino1) {
            int fila = soldado.getFila();
            int columna = soldado.getColumna();
            tablero[fila - 1][columna - 1] = soldado;
        }

        for (Soldado soldado : reino2) {
            int fila = soldado.getFila();
            int columna = soldado.getColumna();
            tablero[fila - 1][columna - 1] = soldado;
        }
    }

   public void mostrarTablero(Soldado[][] tablero) {
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



    public void BonusTerritorio(ArrayList<Soldado> ejercitos) {
        for (Soldado soldado : ejercitos) {
        String reino = soldado.getNombre();
        if (reino.equals("Inglaterra") && territorio.equals("bosque") ||
            reino.equals("Francia") && territorio.equals("campo abierto") ||
            reino.equals("Castilla - Aragón") && territorio.equals("montaña") ||
            reino.equals("Moros") && territorio.equals("desierto") ||
            reino.equals("Sacro Imperio") && (territorio.equals("bosque") || territorio.equals("playa") || territorio.equals("campo abierto"))) {
            
            int nuevoNivelVida = soldado.getNivelVida() + 1;
            soldado.setNivelVida(nuevoNivelVida);
        }
       }
    }
   

 public String getTerritorio() {
        return territorio;
     }
     
    public Soldado[][] getTablero() {
    return tablero;
}
 
    private int Aleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
