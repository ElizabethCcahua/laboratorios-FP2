class Espadachin extends Soldado{
    private int longitudEspada;
    
    public Espadachin() {
        super();
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
}
