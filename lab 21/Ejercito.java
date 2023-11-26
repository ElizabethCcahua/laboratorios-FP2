import java.util.ArrayList;
class Ejercito {
     private String nombre;
    public String reino;
   // almacenaremos todos los herederos de la clase soldado en :
    private ArrayList<Soldado> misSoldados;
    private int fila=Aleatorio(1,10);
    private int columna=Aleatorio(1,10);
    
     public Ejercito() { 
        
        this.misSoldados = new ArrayList<>();    
    }
     
      public Ejercito(String reino) {
          
        this.reino = reino;
        this.misSoldados = new ArrayList<>();
    }
     
       public void asignarReinoAleatorio() {
    String[] reinos = {"Inglaterra", "Francia", "Sacro Imperio", "Castilla - Aragón", "Moros"};
   
    int aleatorio = (int) (Math.random() * reinos.length);
    setReino(reinos[aleatorio]);
   
     }

     //para el ejercito que sera un arreglo estandar
      public Soldado[] generarArregloSoldadosAleatorio() {
    int tamaño = Aleatorio(1, 10); // Generar tamaño aleatorio entre 1 y 10
    Soldado[] soldados = new Soldado[tamaño];
    
    for (int i = 0; i < tamaño; i++) {
        int tipoSoldado = Aleatorio(1, 4);
        switch (tipoSoldado) {
            case 1:
                soldados[i] = new Espadachin();
                break;
            case 2:
                soldados[i] = new Arquero();
                break;
            case 3:
                soldados[i] = new Caballero();
                break;
            case 4:
                soldados[i] = new Lancero();
                break;
            default:
                break;
        }
    }
    
    return soldados;
}
        //agrega una cantidad aleatoria de soldados,Cambio para Agregar los herederos a un solo array incluyendo lancero: 
     public ArrayList<Soldado> generarEjercitoSoldadosAleatorio() {
         asignarReinoAleatorio();
          
    int numSoldados = Aleatorio(1, 10);
    
    for (int i = 0; i < numSoldados; i++) {
        int tipoSoldado = Aleatorio(1, 4);
        switch (tipoSoldado) {
            case 1:
                Espadachin espadachinCreado = new Espadachin();
              
                misSoldados.add(espadachinCreado);
                break;
            case 2:
                Arquero arqueroCreado = new Arquero();
               
                misSoldados.add(arqueroCreado);
                break;
            case 3:
                Caballero caballeroCreado = new Caballero();
                
                misSoldados.add(caballeroCreado);
                break;
            case 4:
                Lancero lanceroCreado = new Lancero();
                
                misSoldados.add(lanceroCreado);
                break;
            default:
                break;
        }
    }
     //para que comience nuevamente de 0
    Soldado.contadorEspadachin=-1;
    Soldado.contadorCaballero=-1;
    Soldado.contadorArquero=-1;
    Soldado.contadorLancero=-1;
    return misSoldados;
}

     public void mostrarResumen() {
    int espadachines = 0;
    int arqueros = 0;
    int caballeros = 0;
    int lanceros = 0;
    int nivelVidaTotal = 0;
    
    for (Soldado soldado : misSoldados) {
        if (soldado instanceof Espadachin) {
            espadachines++;
        } else if (soldado instanceof Arquero) {
            arqueros++;
        } else if (soldado instanceof Caballero) {
            caballeros++;
        } else if (soldado instanceof Lancero) {
            lanceros++;
        }
        
        nivelVidaTotal += soldado.getVidaActual();
    }
    
    System.out.println("Cantidad total de soldados creados: " + misSoldados.size());
    System.out.println("Espadachines: " + espadachines);
    System.out.println("Arqueros: " + arqueros);
    System.out.println("Caballeros: " + caballeros);
    System.out.println("Lanceros: " + lanceros);
    System.out.println("Nivel de vida total del ejército: " + nivelVidaTotal);
}

     public void mostrarProbabilidadVictoria(Ejercito ejercito2) {
    double porcentajeEjercito1 = (double) getSumatoriaNivelVidaSoldados() / (getSumatoriaNivelVidaSoldados() + ejercito2.getSumatoriaNivelVidaSoldados()) * 100;
    double porcentajeEjercito2 = (double) ejercito2.getSumatoriaNivelVidaSoldados() / (getSumatoriaNivelVidaSoldados() + ejercito2.getSumatoriaNivelVidaSoldados()) * 100;

    System.out.println("\nEjercito 1: " + reino + ": " + porcentajeEjercito1 + "% de probabilidad de victoria");
    System.out.println("Ejercito 2: " + ejercito2.getReino() + ": " + porcentajeEjercito2 + "% de probabilidad de victoria");

    double aleatorio = Math.random() * 100;

    if (aleatorio <= porcentajeEjercito1) {
        System.out.println("El ganador es el ejercito 1 de: " + reino + ". Ya que al generar los porcentajes de probabilidad de victoria basada en los niveles de vida de sus soldados y aplicando un experimento aleatorio salió vencedor. (Aleatorio generado: " + aleatorio + ")");
    } else {
        System.out.println("El ganador es el ejercito 2 de: " + ejercito2.getReino() + ". Ya que al generar los porcentajes de probabilidad de victoria basada en los niveles de vida de sus soldados y aplicando un experimento aleatorio salió vencedor. (Aleatorio generado: " + aleatorio + ")");
    }
}

public void mostrarDatosSoldadoMayorVida() {
        int maxVida = 0;
        Soldado soldadoMayorVida = null;
        for (Soldado soldado : misSoldados) {
            if (soldado.getVidaActual() > maxVida) {
                maxVida = soldado.getVidaActual();
                soldadoMayorVida = soldado;
            }
        }
        if (soldadoMayorVida != null) {
            System.out.println(soldadoMayorVida.toString());
           
        } else {
            System.out.println("No hay soldados en el ejército.");
        }
    }

   public void calcularPromedioVidaSoldados() {
    double sumatoriaVida = 0;
    for (Soldado soldado : misSoldados) {
        sumatoriaVida += soldado.getVidaActual();
    }
    
        double promedio = sumatoriaVida / misSoldados.size();
        System.out.println("El promedio de vida de los soldados es: " + promedio);
    
}

    public void mostrarDatosSoldadosEnOrden() {
     
        for (Soldado soldado : misSoldados) {
            System.out.println(soldado.toString());
        }
    }

    
    public void mostrarRankingPoder() {
    
        for (int i = 0; i < misSoldados.size() - 1; i++) {
            for (int j = 0; j < misSoldados.size() - i - 1; j++) {
                if (misSoldados.get(j).getNivelVida() < misSoldados.get(j + 1).getNivelVida()) {
                    Soldado temp = misSoldados.get(j);
                    misSoldados.set(j, misSoldados.get(j + 1));
                    misSoldados.set(j + 1, temp);
                }
            }
        }
        for (Soldado soldado : misSoldados) {
            System.out.println( soldado.getNombre() + " - Nivel de vida: " + soldado.getNivelVida());
        }
    }
    
    public int getSumatoriaNivelVidaSoldados() {
        int sumatoriaNivelVida = 0;
        for (Soldado soldado : misSoldados) {
            sumatoriaNivelVida += soldado.getNivelVida();
        }
        return sumatoriaNivelVida;
    }
    
     public void aumentarVidaActualSoldados() {
        for (Soldado soldado : misSoldados) {
            soldado.setVidaActual(soldado.getVidaActual() + 1);
        }
    }
         
    
    public int obtenerFilaLlegada(int filaActual, String direccion) {
        switch (direccion) {
            case "arriba":
                return this.fila- 1;
            case "abajo":
                return this.fila + 1;
            default:
                return this.fila;
        }
    }
    
    public int obtenerColumnaLlegada(int columnaActual, String direccion) {
        switch (direccion) {
            case "izquierda":
                return this.columna - 1;
            case "derecha":
                return this.columna + 1;
            default:
                return this.columna;
        }
    }
    
    public String toString() {
    return "\nEJERCITO:================> "  + "\n\nSoldados: " + misSoldados.toString();
}
    
    
     public int getCantidadSoldados() {
        return misSoldados.size();
    }

 

     
     public void setMisSoldados(ArrayList<Soldado> misSoldados) {
        this.misSoldados = misSoldados;
    }

    public ArrayList<Soldado> getMisSoldados() {
        return misSoldados;
    }
    
    

     public void setReino(String nombre) {
        this.reino = nombre;
    }
     
     public String getReino() {
    return reino;
       }
    
   
     // Métodos set y get para el atributo fila
    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getFila() {
        return fila;
    }

    // Métodos set y get para el atributo columna
    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getColumna() {
        return columna;
    }
    
    //metodo para poder obtener numeros aleatorios
    public int Aleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    

    
}
