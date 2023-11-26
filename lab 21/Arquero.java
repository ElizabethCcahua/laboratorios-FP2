class Arquero extends Soldado{
    private int numFlechas;
    private static final int NIVEL_ATAQUE = 7;
    private static final int NIVEL_DEFENSA = 3;
    
    public Arquero() {
         super();
        nivelAtaque= NIVEL_ATAQUE ;
       nivelDefensa=NIVEL_DEFENSA ;
       nivelVida=Soldado.Aleatorio(3, 5);
       vidaActual=nivelVida;
        this.setNombre("Arquero " + (getContadorArquero() + 1));
        aumentarContadorArquero();
        this.numFlechas = Aleatorio(1, 10);
          
    }
    
    public Arquero(String nombre, int nivelAtaque, int nivelDefensa, int vidaActual, int velocidad, String actitud, String caracteristica, int numFlechas) {
        super(nombre, nivelAtaque, nivelDefensa, vidaActual, velocidad, actitud, caracteristica);
        this.numFlechas = numFlechas;
    }
    
    // Métodos set y get atributo numFlechas
    public void setNumFlechas(int numFlechas) {
        this.numFlechas = numFlechas;
    }
    
    public int getNumFlechas() {
        return numFlechas;
    }

      @Override
    public String toString() {
        return super.toString() +
                "Número de flechas: " + numFlechas;
    }
    
}
