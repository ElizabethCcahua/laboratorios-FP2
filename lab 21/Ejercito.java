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
      
        //agrega una cantidad aleatoria de soldados,Cambio para Agregar los herederos a un solo array incluyendo lancero: 
     public ArrayList<Soldado> generarEjercitoSoldadosAleatorio() {
         
    int numSoldados = Aleatorio(1, 10);
    
    for (int i = 0; i < numSoldados; i++) {
        int tipoSoldado = Aleatorio(1, 4);
        switch (tipoSoldado) {
            case 1:
                Espadachin espadachinCreado = new Espadachin();
                
                espadachinCreado.setVidaActual(Aleatorio(3, 4));
              
                misSoldados.add(espadachinCreado);
                break;
            case 2:
                Arquero arqueroCreado = new Arquero();
            
                arqueroCreado.setVidaActual(Aleatorio(1, 3));
               
                misSoldados.add(arqueroCreado);
                break;
            case 3:
                Caballero caballeroCreado = new Caballero();
           
                caballeroCreado.setVidaActual(Aleatorio(3, 5));
                
                misSoldados.add(caballeroCreado);
                break;
            case 4:
                Lancero lanceroCreado = new Lancero();
         
                lanceroCreado.setVidaActual(Aleatorio(1, 2));
                
                misSoldados.add(lanceroCreado);
                break;
            default:
                break;
        }
    }
     
    Soldado.contadorEspadachin=0;
    Soldado.contadorCaballero=0;
    Soldado.contadorArquero=0;
    Soldado.contadorLancero=0;
    return misSoldados;
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
            System.out.println("Datos del soldado con mayor vida:");
            System.out.println("Nombre: " + soldadoMayorVida.getNombre());
            System.out.println("Vida actual: " + soldadoMayorVida.getVidaActual());
           
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
        System.out.println("Datos de los soldados en el orden que fueron creados:\n");
        for (Soldado soldado : misSoldados) {
            System.out.println("Nombre: " + soldado.getNombre());
            System.out.println("Vida actual: " + soldado.getVidaActual());
            System.out.println("");
        }
    }

    
    public void mostrarRankingPoder() {
        System.out.println("Ranking de poder (nivel de vida descendente):");
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
    
    
    public void setNombre(String nombre) {
    this.nombre = nombre;
    }

    public String getNombre() {
    return nombre;
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
