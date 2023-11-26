class Espadachin extends Soldado{
    private int longitudEspada;
      private static final int NIVEL_ATAQUE = 10;
    private static final int NIVEL_DEFENSA = 8;
    
    public Espadachin() {
        super();
        nivelAtaque= NIVEL_ATAQUE ;
       nivelDefensa=NIVEL_DEFENSA ;
       nivelVida=Soldado.Aleatorio(8, 10);
       vidaActual=nivelVida;
        this.setNombre("Espadachin " + (getContadorEspadachin() + 1));
        aumentarContadorEspadachin();
        this.longitudEspada = Aleatorio(1, 5);
    }
    
    public Espadachin(String nombre, int nivelAtaque, int nivelDefensa, int vidaActual, int velocidad, String actitud, String caracteristica, int longitudEspada) {
        super(nombre, nivelAtaque, nivelDefensa, vidaActual, velocidad, actitud, caracteristica);
        this.longitudEspada = longitudEspada;
    }
    
    public void crearMuroEscudos() {
        // falta crear método 
    }
    
    // Métodos set y get atributo longitudEspada
    public void setLongitudEspada(int longitudEspada) {
        this.longitudEspada = longitudEspada;
    }
    
    public int getLongitudEspada() {
        return longitudEspada;
    }
     @Override
    public String toString() {
        return super.toString() +
                "Longitud de la espada: " + longitudEspada;
    }
}
